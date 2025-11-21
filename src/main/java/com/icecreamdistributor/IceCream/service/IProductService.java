package com.icecreamdistributor.IceCream.service;

import com.icecreamdistributor.IceCream.dto.request.ProductRequestDto;
import com.icecreamdistributor.IceCream.dto.response.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);

    void deleteProduct(Long id);

    ProductResponseDto getProductById(Long id);

    List<ProductResponseDto> getAllProducts();


}
