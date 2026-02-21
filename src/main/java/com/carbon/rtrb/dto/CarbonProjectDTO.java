package com.carbon.rtrb.dto;

import lombok.Data;

@Data
public class CarbonProjectDTO {
    private String projectName;
    private String projectType;
    private Integer availableTons;
    private String location;
    private String  verificationBody;
    private Double verificationScore;

}
