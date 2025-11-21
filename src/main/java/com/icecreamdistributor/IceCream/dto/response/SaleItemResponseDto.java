package com.icecreamdistributor.IceCream.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleItemResponseDto {

    private String productName;
    private Integer quantity;
    private Double price;

}
