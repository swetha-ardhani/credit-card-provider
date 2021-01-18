package com.sapient.creditcardprovider.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardProviderRequest {
    private String name;
    private String cardNumber;
    private BigDecimal limit;
}
