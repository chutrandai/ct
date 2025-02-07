package com.example.chienthang.backend.dto.request;

import com.example.chienthang.backend.dto.DTO.OrderDetailDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCreateOrUpdateRequest {
    private String orderId;
    private String orderName;
    private String customerName;
    private String shippingLocation;
    private Long amount;
    List<OrderDetailDTO> itemList;
}
