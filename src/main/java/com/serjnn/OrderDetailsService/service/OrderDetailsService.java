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

    public Flux<OrderDetails> findByClientId(Long id) {
        return orderDetailsRepository.findByClientId(id);
    }

    private Mono<Void> save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails).then();
    }

    public Mono<Void> createOrder(OrderDTO orderDTO) {
        OrderDetails orderDetails = new OrderDetails(
                orderDTO.getOrderId(),
                orderDTO.getClientID(),
                getProductIds(orderDTO.getItems()),
                orderDTO.getTotalSum());
        return save(orderDetails);

    }

    private String getProductIds(List<BucketItemDTO> items) {
        return items.stream()
                .map(prod -> prod.getName() + ":" + prod.getQuantity() + "|")
                .collect(Collectors.joining());





    }

    public Mono<Void> remove(UUID uuid) {
        return orderDetailsRepository.deleteByUuid(uuid);
    }
}
