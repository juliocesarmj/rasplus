package com.client.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionTypeDto {

    private Long id;

    @NotBlank(message = "campo requerido")
    @Size(min = 5, max = 30, message = "deve ter tamanho entre 5 e 30")
    private String name;

    @Max(value = 12, message = "não pode ser maior que 12")
    private Long accessMonths;

    @NotNull(message = "não pode ser nulo")
    private BigDecimal price;

    @NotBlank(message = "Campo requerido")
    @Size(min = 5, max = 15, message = "deve ter tamanho entre 5 e 15")
    private String productKey;
}
