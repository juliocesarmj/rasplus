package com.client.ws.service.impl;

import com.client.ws.dto.SubscriptionTypeDto;
import com.client.ws.exceptions.NotFoundException;
import com.client.ws.model.SubscriptionType;
import com.client.ws.repository.SubscriptionTypeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements com.client.ws.service.SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    SubscriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return this.subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        try {
            Optional<SubscriptionType> optionalSubscriptionType = this.subscriptionTypeRepository.findById(id);
            if (optionalSubscriptionType.isEmpty()) {
                throw new NotFoundException("SubscriptionType não encontrada.");
            }
            return optionalSubscriptionType.get();
        } catch (NotFoundException n) {
            throw n;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {
        return this.subscriptionTypeRepository.save(SubscriptionType.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .price(dto.getPrice())
                        .accessMonth(dto.getAccessMonth())
                        .productKey(dto.getProductKey())
                .build());
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionType subscriptionType) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
