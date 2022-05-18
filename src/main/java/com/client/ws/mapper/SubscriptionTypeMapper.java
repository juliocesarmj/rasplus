package com.client.ws.mapper;

import com.client.ws.dto.SubscriptionTypeDto;
import com.client.ws.model.SubscriptionType;

public class SubscriptionTypeMapper {

    private SubscriptionTypeMapper() {
    }
    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto dto) {
        return SubscriptionType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .accessMonths(dto.getAccessMonths())
                .productKey(dto.getProductKey())
                .build();
    }
}
