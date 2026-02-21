package com.carbon.rtrb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OffsetRequestDTO {
    private String companyName;
    private  Integer tonsNeeded;
    private Double maxPricePerTon;
    private String typePreference;
    private LocalDate deadline;
}
