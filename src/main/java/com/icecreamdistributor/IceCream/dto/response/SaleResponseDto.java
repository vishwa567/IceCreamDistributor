package com.icecreamdistributor.IceCream.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponseDto {

    private Long saleId;
    private Double totalAmount;
    private LocalDate saleDate;
    private List<SaleItemResponseDto> items;

}
