package com.serjnn.OrderDetailsService.dto;


import lombok.Data;

@Data
public class DetailsRequest {
    private Long clientId;
    private String productIds;
    private int sum;
}
