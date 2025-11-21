package com.icecreamdistributor.IceCream.dto.request;


import lombok.Data;

@Data
public class StockRequestDto {

    private Long productId;
    private Integer quantity;

}
