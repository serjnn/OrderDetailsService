package com.serjnn.OrderDetailsService.service;


import com.serjnn.OrderDetailsService.model.OrderDetails;
import com.serjnn.OrderDetailsService.repo.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;


    public List<OrderDetails> findAll(){
        return orderDetailsRepository.findAll();
    }
    public List<OrderDetails> findByClientId(Long id){
        return orderDetailsRepository.findByClientId(id);
    }

    public void save(OrderDetails orderDetails){
        orderDetailsRepository.save(orderDetails);
    }


}
