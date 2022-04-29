package com.client.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionTypeDto {

    private Long id;
    private String name;
    private Long accessMonth;
    private BigDecimal price;
    private String productKey;
}
