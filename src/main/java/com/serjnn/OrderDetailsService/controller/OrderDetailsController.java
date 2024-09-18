package com.serjnn.OrderDetailsService.controller;


import com.serjnn.OrderDetailsService.dto.OrderDTO;
import com.serjnn.OrderDetailsService.dto.UuidDTO;
import com.serjnn.OrderDetailsService.model.OrderDetails;
import com.serjnn.OrderDetailsService.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;
    @GetMapping
    List<OrderDetails> getAll(){
        return  orderDetailsService.findAll();
    }

    @GetMapping("/byClient/{id}")
    List<OrderDetails> findByClientId(@PathVariable("id") Long id){
        return orderDetailsService.findByClientId(id);
    }

    @PostMapping("/create")
    void save(@RequestBody OrderDTO orderDTO){
        orderDetailsService.create(orderDTO);
    }

    @PostMapping("/remove")
    void save(@RequestBody UUID uuid){
        orderDetailsService.remove(uuid);
    }
}
