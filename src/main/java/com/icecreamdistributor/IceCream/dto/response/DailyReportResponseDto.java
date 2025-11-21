package com.icecreamdistributor.IceCream.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyReportResponseDto {

    private LocalDate date;
    private Integer totalSales;
    private Double totalRevenue;

}
