package com.icecreamdistributor.IceCream.controller;

import com.icecreamdistributor.IceCream.dto.request.ReportDateRequestDto;
import com.icecreamdistributor.IceCream.dto.response.MonthlyReportResponseDto;
import com.icecreamdistributor.IceCream.dto.response.SaleResponseDto;
import com.icecreamdistributor.IceCream.service.impl.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owner/reports")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/todayRevenue")
    public Double todayReport() {
        return reportService.getDailyRevenue();
    }

    @GetMapping("/monthlyRevenue")
    public Double monthlyReport(@RequestBody ReportDateRequestDto reportDateRequestDto) {
        return reportService.getMonthlyRevenue(reportDateRequestDto);
    }

    @GetMapping("/totalProfit")
    public Double totalProfit() {
        return reportService.getTotalProfit();
    }

    @GetMapping("/todaySales")
    public List<SaleResponseDto> getTodaySales(){
        return reportService.getDailySales();
    }

    @GetMapping("/monthlySales")
    public List<SaleResponseDto> getMonthlySales(){
        return reportService.getMonthlySales();
    }

}
