package com.icecreamdistributor.IceCream.mapper;

import com.icecreamdistributor.IceCream.dto.response.SaleItemResponseDto;
import com.icecreamdistributor.IceCream.dto.response.SaleResponseDto;
import com.icecreamdistributor.IceCream.entity.Sale;
import com.icecreamdistributor.IceCream.entity.SaleItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleMapper {

    public SaleResponseDto toResponseDto(Sale sale, List<SaleItem> items) {

        List<SaleItemResponseDto> itemDtos = items.stream()
                .map(item -> SaleItemResponseDto.builder()
                        .productName(item.getProduct().getName())
                        .quantity(item.getQuantity())
                        .price(item.getPrice())
                        .build())
                .toList();

        return SaleResponseDto.builder()
                .saleId(sale.getId())
                .totalAmount(sale.getTotalAmount())
                .saleDate(sale.getSaleDate())
                .items(itemDtos)
                .build();
    }
}

