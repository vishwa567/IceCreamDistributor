package com.icecreamdistributor.IceCream.controller;

import com.icecreamdistributor.IceCream.dto.request.PurchaseRequestDto;
import com.icecreamdistributor.IceCream.dto.response.PurchaseResponseDto;
import com.icecreamdistributor.IceCream.service.impl.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owner/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping
    public List<PurchaseResponseDto> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public PurchaseResponseDto getPurchaseById(@PathVariable Long id) {
        return purchaseService.getPurchaseById(id);
    }

    @PostMapping("/doPurchase")
    public PurchaseResponseDto makeNewPurchase(@RequestBody PurchaseRequestDto purchaseRequestDto) {
        return purchaseService.createPurchase(purchaseRequestDto);
    }

}
