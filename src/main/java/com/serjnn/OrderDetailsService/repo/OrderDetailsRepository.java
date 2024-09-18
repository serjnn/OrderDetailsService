package com.serjnn.OrderDetailsService.repo;


import com.serjnn.OrderDetailsService.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findByClientId(Long id);

    void deleteByUuid(UUID uuid);

}
