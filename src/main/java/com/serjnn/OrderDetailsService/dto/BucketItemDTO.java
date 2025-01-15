package com.serjnn.OrderDetailsService.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BucketItemDTO {

    private long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
