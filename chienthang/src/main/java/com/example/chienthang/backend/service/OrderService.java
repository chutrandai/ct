package com.example.chienthang.backend.service;

import com.example.chienthang.backend.common.Snowflake;
import com.example.chienthang.backend.dto.DTO.OrderDTO;
import com.example.chienthang.backend.dto.DTO.OrderDetailDTO;
import com.example.chienthang.backend.dto.request.OrderCreateOrUpdateRequest;
import com.example.chienthang.backend.entity.OrderDetailEntity;
import com.example.chienthang.backend.entity.OrderEntity;
import com.example.chienthang.backend.repository.OrderDetailRepository;
import com.example.chienthang.backend.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    private Snowflake snowflake;
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    public OrderDTO findOrderById(String orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElse(null);

        if (orderEntity == null) {
            return null;
        }
        OrderDTO orderDTO = (OrderDTO) orderEntity;
        List<OrderDetailEntity> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        orderDTO.setItemList(orderDetailList);
        return orderDTO;
    }

    public OrderEntity create(OrderCreateOrUpdateRequest request) {
        String orderId = String.valueOf(snowflake.nextId());
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderId);
        orderEntity.setOrderName(request.getOrderName());
        orderEntity.setCustomerName(request.getCustomerName());
        orderEntity.setStatus("01");
        orderEntity.setShippingLocation(request.getShippingLocation());
        orderEntity.setAmount(request.getAmount());
        orderEntity.setCreatedDate(new Date());
        orderEntity.setCreatedBy("admin");
        orderRepository.save(orderEntity);
        List<OrderDetailEntity> orderDetailList = new ArrayList<>();
        for (OrderDetailDTO dto: request.getItemList()) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setOrderDetailId(String.valueOf(snowflake.nextId()));
            orderDetailEntity.setOrderId(orderId);
            orderDetailEntity.setItemId(dto.getItemId());
            orderDetailEntity.setQuantity(dto.getQuantity());
            orderDetailEntity.setUnit(dto.getUnit());
            orderDetailEntity.setTodayPrice(dto.getTodayPrice());
            orderDetailList.add(orderDetailEntity);
        }
        orderDetailRepository.saveAll(orderDetailList);
        return orderEntity;
    }

    public OrderEntity update(OrderCreateOrUpdateRequest request) {
        OrderEntity orderEntity = orderRepository.findById(request.getOrderId()).orElse(null);
        if (orderEntity == null) {
            return null;
        }
        orderDetailRepository.deleteAllByOrderId(orderEntity.getOrderId());

        orderEntity.setOrderName(request.getOrderName());
        orderEntity.setCustomerName(request.getCustomerName());
        orderEntity.setStatus("01");
        orderEntity.setShippingLocation(request.getShippingLocation());
        orderEntity.setAmount(request.getAmount());
        orderEntity.setCreatedDate(new Date());
        orderEntity.setCreatedBy("admin");
        orderRepository.save(orderEntity);
        List<OrderDetailEntity> orderDetailList = new ArrayList<>();
        for (OrderDetailDTO dto: request.getItemList()) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setOrderDetailId(String.valueOf(snowflake.nextId()));
            orderDetailEntity.setOrderId(orderEntity.getOrderId());
            orderDetailEntity.setItemId(dto.getItemId());
            orderDetailEntity.setQuantity(dto.getQuantity());
            orderDetailEntity.setUnit(dto.getUnit());
            orderDetailEntity.setTodayPrice(dto.getTodayPrice());
            orderDetailList.add(orderDetailEntity);
        }
        orderDetailRepository.saveAll(orderDetailList);
        return orderEntity;
    }
    public OrderEntity changeStatus(String orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElse(null);
        if (orderEntity == null) {
            return null;
        }
        orderEntity.setStatus("00".equals(orderEntity.getStatus()) ? "01" : "00");
        return orderEntity;
    }
}
