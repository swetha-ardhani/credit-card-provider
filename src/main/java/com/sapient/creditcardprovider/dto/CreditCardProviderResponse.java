package com.sapient.creditcardprovider.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CreditCardProviderResponse {

    private String name;
    private String cardNumber;
    private BigDecimal limit;
    private BigDecimal balance;
}
