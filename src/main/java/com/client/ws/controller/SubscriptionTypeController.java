package com.client.ws.controller;

import com.client.ws.dto.SubscriptionTypeDto;
import com.client.ws.model.SubscriptionType;
import com.client.ws.service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {

    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.subscriptionTypeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.subscriptionTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SubscriptionType> create(@RequestBody final SubscriptionTypeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.subscriptionTypeService.create(dto));
    }
}
