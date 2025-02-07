package com.example.chienthang.backend.repository;

import com.example.chienthang.backend.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, String> {
    List<OrderDetailEntity> findByOrderId(String orderId);

    boolean deleteAllByOrderId(String orderId);
}
