package com.serjnn.OrderDetailsService.service;


import com.serjnn.OrderDetailsService.dto.OrderDTO;
import com.serjnn.OrderDetailsService.model.OrderDetails;
import com.serjnn.OrderDetailsService.repo.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;


    public Flux<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    public Flux<OrderDetails> findByClientId(Long id) {
        return orderDetailsRepository.findByClientId(id);
    }

    public Mono<Void> save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails).then();
    }


    public Mono<Void> create(OrderDTO orderDTO) {
        String products_ids = orderDTO
                .getItems()
                .stream()
                .map(prod -> prod.getId() + ":" + prod.getQuantity() + "|")
                .collect(Collectors.joining());

        OrderDetails orderDetails = new OrderDetails(
                orderDTO.getOrderId(),
                orderDTO.getClientID(),
                products_ids.substring(0, products_ids.length() - 1),
                orderDTO.getTotalSum());
        return save(orderDetails);

    }



    public Mono<Void> remove(UUID uuid) {
        return orderDetailsRepository.deleteByUuid(uuid);
    }
}
