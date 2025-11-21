package com.icecreamdistributor.IceCream.service;


import com.icecreamdistributor.IceCream.dto.request.ProductRequestDto;
import com.icecreamdistributor.IceCream.dto.request.StockRequestDto;
import com.icecreamdistributor.IceCream.dto.response.ProductStockResponseDto;
import com.icecreamdistributor.IceCream.dto.response.StockResponseDto;

import java.util.List;

public interface IStockService {

    StockResponseDto getStockByProductId(Long productId);

    List<ProductStockResponseDto> getAllStock();

    StockResponseDto increaseStock(StockRequestDto stockRequestDto);  // on purchase

    StockResponseDto decreaseStock(StockRequestDto stockRequestDto);  // on sale

}
