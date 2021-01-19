package com.sapient.creditcardprovider.service;

import com.sapient.creditcardprovider.dao.CreditCard;
import com.sapient.creditcardprovider.dto.CreditCardProviderRequest;
import com.sapient.creditcardprovider.dto.CreditCardProviderResponse;
import com.sapient.creditcardprovider.exceptions.CreditCardProviderException;
import com.sapient.creditcardprovider.repository.CreditCardRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardServiceTest {
    @InjectMocks
    private CreditCardService creditCardService;

    @Mock
    private CreditCardRepository creditCardRepository;

    private CreditCard creditCard;

    private List<CreditCard> creditCardDetails;

    private CreditCardProviderRequest creditCardProviderRequest;


    @Before
    public void setUp() {
        creditCardProviderRequest = CreditCardProviderRequest.builder().name("Jack").cardNumber("1234").limit(new BigDecimal(1400)).build();
    }

    @Test
    public void shouldReturnNonNullResponse_whenValidRequestIsReceived() throws CreditCardProviderException {
        creditCard = CreditCard.builder().name("John").cardNumber("1234").creditLimit(new BigDecimal(1200)).balance(new BigDecimal(0)).build();
        when(creditCardRepository.save(any())).thenReturn(creditCard);
        CreditCardProviderResponse response = creditCardService.addDetails(creditCardProviderRequest);
        Assert.assertNotNull(response);
    }

    @Test
    public void shouldReturnNonNullResponseList_whenGetIsCalled() {
        creditCardDetails = new ArrayList<>();
        creditCard = CreditCard.builder().name("John").cardNumber("1234").creditLimit(new BigDecimal(1200)).balance(new BigDecimal(0)).build();
        creditCardDetails.add(creditCard);
        when(creditCardRepository.findAll()).thenReturn(creditCardDetails);
        List<CreditCard> response = creditCardService.getDetails();
        Assert.assertNotNull(response);
        Assert.assertEquals(1, response.size());
    }

    @Test
    public void shouldReturnEmptyResponseList_whenGetIsCalled() {

        when(creditCardRepository.findAll()).thenReturn(new ArrayList<>());
        List<CreditCard> response = creditCardService.getDetails();
        Assert.assertNotNull(response);
        Assert.assertEquals(0, response.size());
    }

}