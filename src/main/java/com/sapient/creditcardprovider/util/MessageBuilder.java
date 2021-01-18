package com.sapient.creditcardprovider.util;

import com.sapient.creditcardprovider.dao.CreditCard;
import com.sapient.creditcardprovider.dto.CreditCardProviderRequest;
import com.sapient.creditcardprovider.dto.CreditCardProviderResponse;

import java.math.BigDecimal;

public class MessageBuilder {

    public static CreditCard buildRequest(CreditCardProviderRequest creditCardProviderRequest) {
        return CreditCard.builder().name(creditCardProviderRequest.getName()).
                cardNumber(creditCardProviderRequest.getCardNumber()).creditLimit(creditCardProviderRequest.getLimit()).balance(new BigDecimal(0.0)).build();
    }

    public static CreditCardProviderResponse buildResponse(CreditCard request) {
        return CreditCardProviderResponse.builder().cardNumber(request.getCardNumber()).name(request.getName()).limit(request.getCreditLimit()).balance(request.getBalance()).build();
    }
}
