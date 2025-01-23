package com.serjnn.OrderDetailsService.controller;


import com.serjnn.OrderDetailsService.dto.OrderDTO;
import com.serjnn.OrderDetailsService.model.OrderDetails;
import com.serjnn.OrderDetailsService.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @GetMapping("/byClient/{id}")
    Flux<OrderDetails> findByClientId(@PathVariable("id") Long id) {
        return orderDetailsService.findByClientId(id);
    }

    @PostMapping("/addOrder")
    Mono<OrderDetails> save(@RequestBody OrderDTO orderDTO) {
        return orderDetailsService.createOrder(orderDTO);
    }

    @PostMapping("/removeOrder")
    Mono<Void> remove(@RequestBody UUID uuid) {
        return orderDetailsService.removeOrder(uuid);
    }
}
