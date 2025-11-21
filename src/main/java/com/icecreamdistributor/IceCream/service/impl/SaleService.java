package com.icecreamdistributor.IceCream.service.impl;

import com.icecreamdistributor.IceCream.dto.request.SaleItemRequestDto;
import com.icecreamdistributor.IceCream.dto.response.SaleResponseDto;
import com.icecreamdistributor.IceCream.entity.Product;
import com.icecreamdistributor.IceCream.entity.Sale;
import com.icecreamdistributor.IceCream.entity.SaleItem;
import com.icecreamdistributor.IceCream.entity.Stock;
import com.icecreamdistributor.IceCream.mapper.SaleMapper;
import com.icecreamdistributor.IceCream.repository.ProductRepository;
import com.icecreamdistributor.IceCream.repository.SaleItemRepository;
import com.icecreamdistributor.IceCream.repository.SaleRepository;
import com.icecreamdistributor.IceCream.repository.StockRepository;
import com.icecreamdistributor.IceCream.service.ISaleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService {

    private final SaleItemRepository saleItemRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;


    @Override
    public SaleResponseDto createSale(List<SaleItemRequestDto> items) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Enter all the required fields");
        }


        Sale sale = new Sale();
        saleRepository.save(sale);

        Double totalAmount = 0.0;

        List<SaleItem> saleItemList = new ArrayList<>();

        for (SaleItemRequestDto saleItemDto : items) {
            Product product = productRepository.findById(saleItemDto.getProductId()).orElseThrow(
                    () -> new EntityNotFoundException("Product not found on id: " + saleItemDto.getProductId())
            );

            Stock stock = stockRepository.findByProductId(product.getId()).orElseThrow(
                    () -> new EntityNotFoundException("Stock not found on id: " + product.getId())
            );

            if (stock.getQuantity() < saleItemDto.getQuantity()) {
                throw new IllegalArgumentException("Sales are done more than existing stocks");
            }

            stock.setQuantity(stock.getQuantity() - saleItemDto.getQuantity());

            Double soldPrice = product.getSellingPrice() * saleItemDto.getQuantity();
            totalAmount += soldPrice;

            SaleItem saleItem = SaleItem.builder()
                    .price(soldPrice)
                    .quantity(saleItemDto.getQuantity())
                    .sale(sale)
                    .product(product)
                    .build();

            saleItemList.add(saleItem);
            sale.getSaleItems().add(saleItem);

        }


        sale.setTotalAmount(totalAmount);
        saleRepository.save(sale);

        saleItemRepository.saveAll(saleItemList);
        return saleMapper.toResponseDto(sale, saleItemList);
    }

    @Override
    public SaleResponseDto getSaleById(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sales not found of id: " + id));
        List<SaleItem> saleItemList = saleItemRepository.findAllBySaleId(id);
        return saleMapper.toResponseDto(sale, saleItemList);
    }

    @Override
    public List<SaleResponseDto> getAllSales() {
        List<SaleItem> saleItemList = saleItemRepository.findAll();
        return saleRepository.findAll()
                .stream()
                .map(sale -> saleMapper.toResponseDto(sale, saleItemList))
                .toList();
    }
}
