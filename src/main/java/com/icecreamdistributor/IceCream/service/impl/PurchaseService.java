package com.icecreamdistributor.IceCream.service.impl;

import com.icecreamdistributor.IceCream.dto.request.PurchaseRequestDto;
import com.icecreamdistributor.IceCream.dto.response.PurchaseResponseDto;
import com.icecreamdistributor.IceCream.entity.Product;
import com.icecreamdistributor.IceCream.entity.Purchase;
import com.icecreamdistributor.IceCream.mapper.PurchaseMapper;
import com.icecreamdistributor.IceCream.repository.ProductRepository;
import com.icecreamdistributor.IceCream.repository.PurchaseRepository;
import com.icecreamdistributor.IceCream.service.IPurchaseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PurchaseService implements IPurchaseService {

    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public PurchaseResponseDto createPurchase(PurchaseRequestDto purchaseRequestDto) {
        if(purchaseRequestDto == null) {
            throw new IllegalArgumentException("Enter all the required parameters");
        }

        Product product = productRepository.findById(purchaseRequestDto.getProductId()).orElseThrow(
                () -> new EntityNotFoundException("No such product exist by id: " + purchaseRequestDto.getProductId())
        );

        Double totalAmount = product.getPurchasePrice() * purchaseRequestDto.getQuantity();


        Purchase purchase = Purchase.builder()
                .product(product)
                .quantity(purchaseRequestDto.getQuantity())
                .totalPrice(totalAmount)
                .build();

        Purchase savedPurchase = purchaseRepository.save(purchase);
        product.getPurchases().add(purchase);

        return purchaseMapper.toResponseDto(purchase);
    }

    @Override
    public PurchaseResponseDto getPurchaseById(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such product exist by id: " + id)
        );
        return purchaseMapper.toResponseDto(purchase);
    }

    @Override
    public List<PurchaseResponseDto> getAllPurchases() {
        return purchaseRepository.findAll()
                .stream()
                .map(purchaseMapper::toResponseDto)
                .toList();
    }
}
