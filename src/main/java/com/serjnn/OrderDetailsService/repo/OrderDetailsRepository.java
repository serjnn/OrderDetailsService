package com.serjnn.OrderDetailsService.repo;


import com.serjnn.OrderDetailsService.model.OrderDetails;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface OrderDetailsRepository extends ReactiveCrudRepository<OrderDetails, Long> {
    Flux<OrderDetails> findByClientId(Long id);

    Mono<Void> deleteByUuid(UUID uuid);

}
