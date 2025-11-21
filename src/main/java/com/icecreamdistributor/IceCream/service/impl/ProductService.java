package com.icecreamdistributor.IceCream.service.impl;

import com.icecreamdistributor.IceCream.dto.request.ProductRequestDto;
import com.icecreamdistributor.IceCream.dto.response.ProductResponseDto;
import com.icecreamdistributor.IceCream.entity.Product;
import com.icecreamdistributor.IceCream.entity.Stock;
import com.icecreamdistributor.IceCream.mapper.ProductMapper;
import com.icecreamdistributor.IceCream.repository.*;
import com.icecreamdistributor.IceCream.service.IProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements IProductService {

    private final UsersRepository usersRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final ProductMapper productMapper;
    private final PurchaseRepository purchaseRepository;
    private final SaleItemRepository saleItemRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {

        if (productRequestDto == null)
            throw new IllegalArgumentException("Enter all the required fields");

        Product product = Product.builder()
                .name(productRequestDto.getName())
                .brand(productRequestDto.getBrand())
                .category(productRequestDto.getCategory())
                .purchasePrice(productRequestDto.getPurchasePrice())
                .sellingPrice(productRequestDto.getSellingPrice())
                .build();

        Product savedProduct = productRepository.save(product);

        Stock stock = Stock.builder()
                .product(savedProduct)
                .quantity(0)
                .build();

        stockRepository.save(stock);
        savedProduct.setStock(stock);

        return productMapper.toResponseDto(savedProduct);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        if (productRequestDto == null) {
            throw new IllegalArgumentException("Enter all the required field");
        }

        Product existingProduct = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such product exist by id: " + id)
        );

        Product productEntity = productMapper.toEntity(productRequestDto, existingProduct);
        productRepository.save(productEntity);
        return productMapper.toResponseDto(productEntity);

    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No such product exist by id: " + id));
        productRepository.delete(product);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such product exist by id: " + id)
        );
        return productMapper.toResponseDto(existingProduct);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponseDto)
                .toList();
    }
}
