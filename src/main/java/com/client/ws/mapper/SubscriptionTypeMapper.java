package com.client.ws.mapper;

import com.client.ws.dto.SubscriptionTypeDto;
import com.client.ws.model.SubscriptionType;

public class SubscriptionTypeMapper {

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto dto) {
        return SubscriptionType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .accessMonth(dto.getAccessMonth())
                .productKey(dto.getProductKey())
                .build();
    }
}
