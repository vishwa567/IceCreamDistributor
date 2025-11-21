package com.icecreamdistributor.IceCream.service.impl;

import com.icecreamdistributor.IceCream.dto.request.StockRequestDto;
import com.icecreamdistributor.IceCream.dto.response.ProductStockResponseDto;
import com.icecreamdistributor.IceCream.dto.response.StockResponseDto;
import com.icecreamdistributor.IceCream.entity.Product;
import com.icecreamdistributor.IceCream.entity.Stock;
import com.icecreamdistributor.IceCream.mapper.StockMapper;
import com.icecreamdistributor.IceCream.repository.ProductRepository;
import com.icecreamdistributor.IceCream.repository.StockRepository;
import com.icecreamdistributor.IceCream.service.IStockService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService implements IStockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;
    private final ProductRepository productRepository;

    @Override
    public StockResponseDto getStockByProductId(Long productId) {
        Stock stock = stockRepository.findByProductId(productId).orElseThrow(
                () -> new EntityNotFoundException("No such product exist by id: " + productId)
        );
        return stockMapper.toResponseDto(stock);
    }

    @Override
    public List<ProductStockResponseDto> getAllStock() {
       return productRepository.findAll()
               .stream()
               .map(stockMapper::toProductStockResponseDto)
               .toList();
    }

    @Override
    public StockResponseDto increaseStock(StockRequestDto stockRequestDto) {
        Stock stock = stockRepository.findByProductId(stockRequestDto.getProductId()).orElseThrow(
                () -> new EntityNotFoundException("No such product exist by id: " + stockRequestDto.getProductId())
        );

        if(stockRequestDto.getQuantity() <= 0) {
            throw new IllegalArgumentException("Incremental quantity must be at least 1 or more");
        }

        stock.setQuantity(stock.getQuantity() + stockRequestDto.getQuantity());

        Product product = productRepository.findById(stockRequestDto.getProductId()).orElseThrow(
                () -> new EntityNotFoundException("No such product exist by id: " + stockRequestDto.getProductId())
        );

        product.setStock(stock);

        stockRepository.save(stock);

        return stockMapper.toResponseDto(stock);
    }

    @Override
    public StockResponseDto decreaseStock(StockRequestDto stockRequestDto) {
        Stock stock = stockRepository.findByProductId(stockRequestDto.getProductId()).orElseThrow(
                () -> new EntityNotFoundException("No such product exist by id: " + stockRequestDto.getProductId())
        );

        if(stockRequestDto.getQuantity() > stock.getQuantity()) {
            throw new IllegalArgumentException("Decremental quantity must not be greater existing quantity");
        }


        Product product = productRepository.findById(stockRequestDto.getProductId()).orElseThrow(
                () -> new EntityNotFoundException("No such product exist by id: " + stockRequestDto.getProductId())
        );


        stock.setQuantity(stock.getQuantity() - stockRequestDto.getQuantity());

        product.setStock(stock);

        Stock savedStock = stockRepository.save(stock);

        return stockMapper.toResponseDto(savedStock);
    }
}
