package com.icecreamdistributor.IceCream.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductStockResponseDto {

    private Long productId;
    private String productName;
    private Integer quantity;

}
