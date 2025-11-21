package com.icecreamdistributor.IceCream.dto.request;

import lombok.Data;

@Data
public class PurchaseRequestDto {

    private Long productId;
    private Integer quantity;

}
