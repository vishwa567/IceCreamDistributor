package com.icecreamdistributor.IceCream.service;

import com.icecreamdistributor.IceCream.dto.request.SaleItemRequestDto;
import com.icecreamdistributor.IceCream.dto.response.SaleResponseDto;

import java.util.List;

public interface ISaleService {

    SaleResponseDto createSale(List<SaleItemRequestDto> items); // custom DTO

    SaleResponseDto getSaleById(Long id);

    List<SaleResponseDto> getAllSales();


}
