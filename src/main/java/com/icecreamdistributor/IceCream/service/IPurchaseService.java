package com.icecreamdistributor.IceCream.service;

import com.icecreamdistributor.IceCream.dto.request.PurchaseRequestDto;
import com.icecreamdistributor.IceCream.dto.response.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseService {

    PurchaseResponseDto createPurchase(PurchaseRequestDto purchaseRequestDto);

    PurchaseResponseDto getPurchaseById(Long id);

    List<PurchaseResponseDto> getAllPurchases();


}
