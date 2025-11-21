package com.icecreamdistributor.IceCream.controller;

import com.icecreamdistributor.IceCream.dto.request.SaleItemRequestDto;
import com.icecreamdistributor.IceCream.dto.response.SaleResponseDto;
import com.icecreamdistributor.IceCream.service.impl.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owner/sales")
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public List<SaleResponseDto> getAllSales() {
        return saleService.getAllSales();
    }

    @PostMapping("/addSale")
    public SaleResponseDto createSales(@RequestBody List<SaleItemRequestDto> saleItemRequestDtoList) {
        return saleService.createSale(saleItemRequestDtoList);
    }

    @GetMapping("/{id}")
    public SaleResponseDto getSaleById(@PathVariable Long id) {
        return saleService.getSaleById(id);
    }


}
