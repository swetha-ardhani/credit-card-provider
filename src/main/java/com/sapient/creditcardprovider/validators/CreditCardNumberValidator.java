package com.sapient.creditcardprovider.validators;

import com.sapient.creditcardprovider.dto.CreditCardProviderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreditCardNumberValidator implements Validator {

    @Override
    public ValidationResult validate(CreditCardProviderRequest requestBean) {
        log.info("Validating Credit Card Number");
        String cardNumber = requestBean.getCardNumber();
        int[] creditCardAsNumber = new int[cardNumber.length()];

        for (int i = 0; i < cardNumber.length(); i++) {
            creditCardAsNumber[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
        }
        // Starting from the right, double each other digit, if greater than 9, mod 10 and plus 1 to the remainder
        for (int i = creditCardAsNumber.length - 2; i >= 0; i = i - 2) {
            int tempValue = creditCardAsNumber[i];
            tempValue = tempValue * 2;
            if (tempValue > 9) {
                tempValue = tempValue % 10 + 1;
            }
            creditCardAsNumber[i] = tempValue;
        }

        //Add up all teh digits
        int sum = 0;
        for (int i = 0; i < creditCardAsNumber.length; i++) {
            sum += creditCardAsNumber[i];
        }
        //If Number is multiple of 10, its valid
        if (sum % 10 == 0) {
            log.debug("Valid CreditCard Number");
            return ValidationResult.valid();
        } else {
            log.error("InValid CreditCard Number- Not Compatible");
            return ValidationResult.inValid("Invalid CreditCard Number- Not Compatible");
        }
    }
}
