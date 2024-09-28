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

    @GetMapping
    Flux<OrderDetails> getAll() {
        return orderDetailsService.findAll();
    }

    @GetMapping("/byClient/{id}")
    Flux<OrderDetails> findByClientId(@PathVariable("id") Long id) {
        return orderDetailsService.findByClientId(id);
    }

    @PostMapping("/create")
    Mono<Void> save(@RequestBody OrderDTO orderDTO) {
        return orderDetailsService.create(orderDTO).then();
    }

    @PostMapping("/remove")
    Mono<Void> save(@RequestBody UUID uuid) {
        return orderDetailsService.remove(uuid);
    }
}
