package com.icecreamdistributor.IceCream.controller;

import com.icecreamdistributor.IceCream.dto.request.SignupRequestDto;
import com.icecreamdistributor.IceCream.dto.request.StockRequestDto;
import com.icecreamdistributor.IceCream.dto.response.ProductStockResponseDto;
import com.icecreamdistributor.IceCream.dto.response.StockResponseDto;
import com.icecreamdistributor.IceCream.service.impl.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public List<ProductStockResponseDto> getAllStocks() {
        return stockService.getAllStock();
    }

    @GetMapping("/{productId}")
    public StockResponseDto getStockByProductId(@PathVariable Long productId) {
        return stockService.getStockByProductId(productId);
    }

    @PutMapping("/increase")
    public StockResponseDto increaseStock(@RequestBody StockRequestDto requestDto) {
        return stockService.increaseStock(requestDto);
    }

    @PutMapping("/decrease")
    public StockResponseDto decreaseStock(@RequestBody StockRequestDto requestDto) {
        return stockService.decreaseStock(requestDto);
    }


}
