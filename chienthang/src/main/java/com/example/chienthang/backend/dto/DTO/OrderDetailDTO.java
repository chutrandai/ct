package com.example.chienthang.backend.dto.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {
    private String itemId;
    private Long quantity;
    private String unit;
    private Long todayPrice;
}
