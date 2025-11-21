package com.icecreamdistributor.IceCream.service.impl;

import com.icecreamdistributor.IceCream.dto.request.ReportDateRequestDto;
import com.icecreamdistributor.IceCream.dto.response.SaleResponseDto;
import com.icecreamdistributor.IceCream.entity.Sale;
import com.icecreamdistributor.IceCream.entity.SaleItem;
import com.icecreamdistributor.IceCream.mapper.SaleMapper;
import com.icecreamdistributor.IceCream.repository.PurchaseRepository;
import com.icecreamdistributor.IceCream.repository.SaleItemRepository;
import com.icecreamdistributor.IceCream.repository.SaleRepository;
import com.icecreamdistributor.IceCream.service.IReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService implements IReportService {

    private final SaleRepository saleRepository;
    private final PurchaseRepository purchaseRepository;
    private final SaleItemRepository saleItemRepository;
    private final SaleMapper saleMapper;
    private final SaleService saleService;

    @Override
    public Double getDailyRevenue() {
        LocalDate todayDate = LocalDate.now();
        return saleRepository.sumBySaleDate(todayDate);
    }

    @Override
    public Double getMonthlyRevenue(ReportDateRequestDto requestDto) {
        return saleRepository.sumBySaleDateBetween(requestDto.getStartingDate(), requestDto.getEndingDate());
    }

    @Override
    public Double getTotalProfit() {

        List<SaleItem> saleItems = saleItemRepository.findAll();

        double totalSellingAmount = 0.0;
        double totalCostAmount = 0.0;

        for (SaleItem item : saleItems) {

            // SOLD PRICE (already calculated in sale logic)
            totalSellingAmount += item.getPrice();  // price = sellingPrice * quantity

            // COST PRICE
            double productCost = item.getProduct().getPurchasePrice() * item.getQuantity();
            totalCostAmount += productCost;
        }

        return totalSellingAmount - totalCostAmount;
    }

    @Override
    public List<SaleResponseDto> getDailySales() {

        LocalDate today = LocalDate.now();

        List<Sale> sales = saleRepository.findBySaleDate(today);

        return sales.stream()
                .map(sale -> saleMapper.toResponseDto(
                        sale,
                        new ArrayList<>(sale.getSaleItems())
                ))
                .toList();
    }

    @Override
    public List<SaleResponseDto> getMonthlySales() {

        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate end = LocalDate.now();

        List<Sale> sales = saleRepository.findBySaleDateBetween(start, end);

        return sales.stream()
                .map(sale -> saleMapper.toResponseDto(
                        sale,
                        new ArrayList<>(sale.getSaleItems())  // passing sale items
                ))
                .toList();
    }

}
