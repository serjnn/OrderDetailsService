package com.serjnn.OrderDetailsService.service;


import com.serjnn.OrderDetailsService.dto.OrderDTO;
import com.serjnn.OrderDetailsService.model.OrderDetails;
import com.serjnn.OrderDetailsService.repo.OrderDetailsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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


    public void create(OrderDTO orderDTO) {
        String products_ids = orderDTO
                .getItems()
                .stream()
                .map(prod -> prod.getId() + ":" + prod.getQuantity() + "|")
                .collect(Collectors.joining());

        OrderDetails orderDetails = new OrderDetails(
                orderDTO.getOrderId(),
                orderDTO.getClientID(),
                products_ids.substring(0,products_ids.length()-1),
                orderDTO.getTotalSum());
        save(orderDetails);

    }


    @Transactional
    public void remove(UUID uuid) {
        orderDetailsRepository.deleteByUuid(uuid);
    }
}
