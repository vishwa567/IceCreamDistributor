package com.icecreamdistributor.IceCream.mapper;

import com.icecreamdistributor.IceCream.dto.response.ProductStockResponseDto;
import com.icecreamdistributor.IceCream.dto.response.StockResponseDto;
import com.icecreamdistributor.IceCream.entity.Product;
import com.icecreamdistributor.IceCream.entity.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {

    public StockResponseDto toResponseDto(Stock stock) {
        return StockResponseDto.builder()
                .productName(stock.getProduct().getName())
                .quantity(stock.getQuantity())
                .productId(stock.getId())
                .build();
    }

    public ProductStockResponseDto toProductStockResponseDto(Product product) {
        return ProductStockResponseDto.builder()
                .productId(product.getId())
                .productName(product.getName())
                .quantity(product.getStock().getQuantity())
                .build();
    }

}
