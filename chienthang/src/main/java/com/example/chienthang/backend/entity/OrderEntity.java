package com.example.chienthang.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "status")
    private String status;

    @Column(name = "shipping_location")
    private String shippingLocation;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;
}
