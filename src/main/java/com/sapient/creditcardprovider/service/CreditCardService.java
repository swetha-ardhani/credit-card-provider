package com.sapient.creditcardprovider.service;

import com.sapient.creditcardprovider.dao.CreditCard;
import com.sapient.creditcardprovider.dto.CreditCardProviderRequest;
import com.sapient.creditcardprovider.dto.CreditCardProviderResponse;
import com.sapient.creditcardprovider.exceptions.CreditCardProviderException;
import com.sapient.creditcardprovider.repository.CreditCardRepository;
import com.sapient.creditcardprovider.util.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sapient.creditcardprovider.validators.ValidationResult;
import com.sapient.creditcardprovider.validators.ValidatorService;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private ValidatorService validatorService;

    public CreditCardProviderResponse addDetails(CreditCardProviderRequest creditCardProviderRequest) throws CreditCardProviderException {
        ValidationResult validationResult = validatorService.validateAll(creditCardProviderRequest);
        if (!validationResult.isValid()) {
            throw new CreditCardProviderException(validationResult.getValidateMsg());
        }
        CreditCard request = creditCardRepository.save(MessageBuilder.buildRequest(creditCardProviderRequest));
        return MessageBuilder.buildResponse(request);
    }

    public List<CreditCard> getDetails() {
        return creditCardRepository.findAll();
    }
}
