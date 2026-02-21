package com.carbon.rtrb.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "carbon_projects")
public class CarbonProject {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_type")
    private String projectType;

    @Column(name = "available_tons")
    private Integer availableTons;

    private String location;

    @Column(name = "verification_body")
    private String verificationBody;

    @Column(name = "verification_score")
    private Double verificationScore;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}