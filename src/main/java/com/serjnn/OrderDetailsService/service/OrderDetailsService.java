package com.serjnn.OrderDetailsService.service;


import com.serjnn.OrderDetailsService.dto.BucketItemDTO;
import com.serjnn.OrderDetailsService.dto.OrderDTO;
import com.serjnn.OrderDetailsService.model.OrderDetails;
import com.serjnn.OrderDetailsService.repo.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public Flux<OrderDetails> findByClientId(long id) {
        return orderDetailsRepository.findByClientId(id);
    }



    public Mono<OrderDetails> createOrder(OrderDTO orderDTO) {
        OrderDetails orderDetails = new OrderDetails(
                orderDTO.getOrderId(),
                orderDTO.getClientId(),
                this.getProductIds(orderDTO.getItems()),
                orderDTO.getTotalSum());
        return orderDetailsRepository.save(orderDetails);

    }

    private String getProductIds(List<BucketItemDTO> items) {
        return items.stream()
                .map(prod -> prod.getName()
                        .concat(":")
                        .concat(prod.getQuantity().toString())
                        .concat("|"))
                .collect(Collectors.joining());
    }

    public Mono<Void> removeOrder(UUID uuid) {
        return orderDetailsRepository.deleteByUuid(uuid);
    }
}
