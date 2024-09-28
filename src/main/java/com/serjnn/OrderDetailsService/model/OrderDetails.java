package com.serjnn.OrderDetailsService.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "order_details")
public class OrderDetails {
    @Id
    private long id;

    private UUID uuid;

    private Long clientId;
    private String products_ids;
    private BigDecimal sum;

    private LocalDateTime created_at;


    public OrderDetails(UUID uuid, Long clientId, String products_ids, BigDecimal sum) {
        this.uuid = uuid;
        this.clientId = clientId;
        this.products_ids = products_ids;
        this.sum = sum;
        this.created_at = LocalDateTime.now();
    }
}