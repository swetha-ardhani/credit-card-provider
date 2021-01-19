package com.sapient.creditcardprovider.validators;

import com.sapient.creditcardprovider.dto.CreditCardProviderRequest;

public interface Validator {
    ValidationResult validate(CreditCardProviderRequest requestBean);
}
