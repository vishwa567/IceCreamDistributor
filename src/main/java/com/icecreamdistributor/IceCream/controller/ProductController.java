package com.icecreamdistributor.IceCream.controller;

import com.icecreamdistributor.IceCream.dto.request.ProductRequestDto;
import com.icecreamdistributor.IceCream.dto.response.ProductResponseDto;
import com.icecreamdistributor.IceCream.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owner/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductByName(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto addNewProduct(@RequestBody ProductRequestDto requestDto) {
        return productService.createProduct(requestDto);
    }

    @PostMapping("/update/{id}")
    public ProductResponseDto updateExistingProduct(@PathVariable Long id, @RequestBody ProductRequestDto requestDto) {
        return productService.updateProduct(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}
