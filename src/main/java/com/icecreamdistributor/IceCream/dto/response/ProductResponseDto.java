package com.icecreamdistributor.IceCream.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private Long id;
    private String name;
    private String brand;
    private String category;
    private Double purchasePrice;
    private Double sellingPrice;
    private Integer currentStock;

}
