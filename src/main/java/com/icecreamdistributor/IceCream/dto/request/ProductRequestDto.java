package com.icecreamdistributor.IceCream.dto.request;

import lombok.Data;

@Data
public class ProductRequestDto {

    private String name;
    private String brand;
    private String category;
    private Double purchasePrice;
    private Double sellingPrice;

}
