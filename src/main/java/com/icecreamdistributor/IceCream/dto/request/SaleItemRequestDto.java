package com.icecreamdistributor.IceCream.dto.request;

import lombok.Data;

@Data
public class SaleItemRequestDto {

    private Long productId;
    private Integer quantity;

}
