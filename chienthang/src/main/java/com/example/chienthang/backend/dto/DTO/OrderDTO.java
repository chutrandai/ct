package com.example.chienthang.backend.dto.DTO;

import com.example.chienthang.backend.entity.OrderDetailEntity;
import com.example.chienthang.backend.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO extends OrderEntity {
    private List<OrderDetailEntity> itemList;
}
