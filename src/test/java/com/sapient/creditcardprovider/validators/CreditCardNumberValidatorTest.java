package com.sapient.creditcardprovider.validators;

import com.sapient.creditcardprovider.dto.CreditCardProviderRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreditCardNumberValidatorTest {

    private CreditCardNumberValidator creditCardNumberValidator;
    private CreditCardProviderRequest request;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {CreditCardProviderRequest.builder().cardNumber("4111111111111111").build(),true},
                {CreditCardProviderRequest.builder().cardNumber("12345").build(),false},
                {CreditCardProviderRequest.builder().cardNumber("12345123456").build(),false},
                {CreditCardProviderRequest.builder().cardNumber("5500000000000004").build(),true},
                {CreditCardProviderRequest.builder().cardNumber("340000000000009").build(),true}
        });
    }

    private CreditCardProviderRequest input;
    private boolean output;

    public CreditCardNumberValidatorTest(CreditCardProviderRequest input, boolean output){
        this.input= input;
        this.output = output;
    }

    @Before
    public void setUp() {
        creditCardNumberValidator = new CreditCardNumberValidator();
    }
    @Test
    public void testWithParameters(){
        assertEquals(output,creditCardNumberValidator.validate(input).isValid());
    }


}