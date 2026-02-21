package com.carbon.rtrb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "offset_requests")
public class OffsetRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "tons_needed")
    private Integer tonsNeeded;

    @Column(name = "max_price_per_ton")
    private Double maxPricePerTon;

    @Column(name = "type_preference")
    private String typePreference;

    private LocalDate deadline;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
