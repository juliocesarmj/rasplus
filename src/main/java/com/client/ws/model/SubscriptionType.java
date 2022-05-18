package com.client.ws.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "subscriptions_type")
public class SubscriptionType implements Serializable {

    @Id
    @Column(name = "subscriptions_type_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "access_months")
    private Long accessMonths;
    private BigDecimal price;

    @Column(name = "product_key", unique = true, nullable = false)
    private String productKey;

}
