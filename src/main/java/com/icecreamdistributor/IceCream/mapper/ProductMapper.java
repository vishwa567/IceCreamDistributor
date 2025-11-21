package com.icecreamdistributor.IceCream.mapper;

import com.icecreamdistributor.IceCream.dto.request.ProductRequestDto;
import com.icecreamdistributor.IceCream.dto.response.ProductResponseDto;
import com.icecreamdistributor.IceCream.entity.Product;
import com.icecreamdistributor.IceCream.entity.Stock;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDto toResponseDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .brand(product.getBrand())
                .category(product.getCategory())
                .purchasePrice(product.getPurchasePrice())
                .sellingPrice(product.getSellingPrice())
                .currentStock(product.getStock().getQuantity())
                .build();
    }

    public Product toEntity(ProductRequestDto productRequestDto, Product existingProduct) {
        existingProduct.setBrand(productRequestDto.getBrand());
        existingProduct.setName(productRequestDto.getName());
        existingProduct.setCategory(productRequestDto.getCategory());
        existingProduct.setPurchasePrice(productRequestDto.getPurchasePrice());
        existingProduct.setSellingPrice(productRequestDto.getSellingPrice());
        return existingProduct;
    }


}
