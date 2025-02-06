package com.example.chienthang.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ct_order")
@Getter
@Setter
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    private String oderId;

    @Column(name = "order_name")
    private String oderName;
}
