package com.example.chienthang.backend.controller;

import com.example.chienthang.backend.dto.DTO.OrderDTO;
import com.example.chienthang.backend.dto.request.OrderCreateOrUpdateRequest;
import com.example.chienthang.backend.entity.OrderEntity;
import com.example.chienthang.backend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "order")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    @GetMapping(value = "search")
    public List<OrderEntity> search() {
        return orderService.findAll();
    }

    @GetMapping(value = "detail")
    public OrderDTO detail(@RequestParam String orderId) {
        return orderService.findOrderById(orderId);
    }

    @PostMapping(value = "create")
    public OrderEntity create(@RequestBody OrderCreateOrUpdateRequest request) {
        return orderService.create(request);
    }

    @PostMapping(value = "update")
    public OrderEntity update(@RequestBody OrderCreateOrUpdateRequest request) {
        return orderService.update(request);
    }

    @PostMapping(value = "change-status")
    public OrderEntity changeStatus(@RequestParam String orderId) {
        return orderService.changeStatus(orderId);
    }
}
