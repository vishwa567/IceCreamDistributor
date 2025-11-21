package com.icecreamdistributor.IceCream.service;

import com.icecreamdistributor.IceCream.dto.request.ReportDateRequestDto;
import com.icecreamdistributor.IceCream.dto.response.SaleResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IReportService {

    Double getDailyRevenue();

    Double getMonthlyRevenue(ReportDateRequestDto requestDto);

    Double getTotalProfit();

    List<SaleResponseDto> getDailySales();

    List<SaleResponseDto> getMonthlySales();


}
