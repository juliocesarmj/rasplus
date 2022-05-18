package com.client.ws.service.impl;

import com.client.ws.dto.SubscriptionTypeDto;
import com.client.ws.exceptions.BadRequestException;
import com.client.ws.exceptions.NotFoundException;
import com.client.ws.mapper.SubscriptionTypeMapper;
import com.client.ws.model.SubscriptionType;
import com.client.ws.repository.SubscriptionTypeRepository;
import com.client.ws.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

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
        return this.getSubscriptionType(id);
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {

        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ERROR: Houve uma tentativa de inserção de um dado não permitido.");
        }
        return this.subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
        this.getSubscriptionType(id);
        dto.setId(id);
        return this.subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        this.subscriptionTypeRepository.delete(this.getSubscriptionType(id));
    }

    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = this.subscriptionTypeRepository.findById(id);
        if (optionalSubscriptionType.isEmpty()) {
            throw new NotFoundException("SubscriptionType não encontrada.");
        }
        return optionalSubscriptionType.get();
    }
}
