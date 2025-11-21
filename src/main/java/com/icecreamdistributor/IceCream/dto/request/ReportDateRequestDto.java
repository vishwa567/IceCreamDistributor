package com.icecreamdistributor.IceCream.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportDateRequestDto {

    private LocalDate startingDate;
    private LocalDate endingDate;

}
