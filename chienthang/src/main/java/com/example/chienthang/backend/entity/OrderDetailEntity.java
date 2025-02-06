package com.example.chienthang.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ct_order_detail")
@Getter
@Setter
public class OrderDetailEntity {
    @Id
    @Column(name = "order_detail_id")
    private String orderDetailId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "unit")
    private String unit;

    @Column(name = "today_price")
    private Long todayPrice;
}
