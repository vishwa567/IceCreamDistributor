package com.icecreamdistributor.IceCream.mapper;

import com.icecreamdistributor.IceCream.dto.response.PurchaseResponseDto;
import com.icecreamdistributor.IceCream.entity.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

    public PurchaseResponseDto toResponseDto(Purchase purchase) {
        return PurchaseResponseDto.builder()
                .id(purchase.getId())
                .productName(purchase.getProduct().getName())
                .quantity(purchase.getQuantity())
                .totalPrice(purchase.getTotalPrice())
                .purchaseDate(purchase.getPurchaseDate())
                .build();
    }

}
