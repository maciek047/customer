package com.kodilla.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDto {
    private long id;
    private String cardNumber;
    private String currency;
    private BigDecimal availableFunds;
}
