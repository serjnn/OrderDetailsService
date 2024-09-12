package com.serjnn.OrderDetailsService.controller;


import com.serjnn.OrderDetailsService.dto.DetailsRequest;
import com.serjnn.OrderDetailsService.model.OrderDetails;
import com.serjnn.OrderDetailsService.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    void save(@RequestBody DetailsRequest detailsRequest){
        OrderDetails orderDetails = new OrderDetails(
                detailsRequest.getClientId(),

                detailsRequest.getProductIds(),
                detailsRequest.getSum());
        orderDetailsService.save(orderDetails);

    }
}
