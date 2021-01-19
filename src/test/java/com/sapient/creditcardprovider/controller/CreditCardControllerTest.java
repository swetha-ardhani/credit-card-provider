package com.sapient.creditcardprovider.controller;

import com.sapient.creditcardprovider.dao.CreditCard;
import com.sapient.creditcardprovider.dto.CreditCardProviderRequest;
import com.sapient.creditcardprovider.dto.CreditCardProviderResponse;
import com.sapient.creditcardprovider.exceptions.CreditCardProviderException;
import com.sapient.creditcardprovider.service.CreditCardService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardControllerTest {

    @InjectMocks
    private CreditCardController creditCardController;
    @Mock
    private CreditCardService creditCardService;

    private CreditCardProviderRequest creditCardProviderRequest;

    private CreditCardProviderResponse creditCardProviderResponse;

    private List<CreditCard> creditCardDetails;

    @Before
    public void setUp() {
        creditCardProviderRequest = CreditCardProviderRequest.builder().name("Swetha").cardNumber("").limit(new BigDecimal(1200.00)).build();
    }

    @Test
    public void shouldReturn201Response_whenValidRequestIsSent() throws CreditCardProviderException {
        when(creditCardService.addDetails(any())).thenReturn(creditCardProviderResponse);
        ResponseEntity<CreditCardProviderResponse> response = creditCardController.addCreditCardDetails(creditCardProviderRequest);
        Assert.assertTrue(response.getStatusCode()== HttpStatus.CREATED);
        Assert.assertNotNull(response);
    }

    @Test
    public void shouldReturn20OResponsewithEmptyList_whenNoAccountsArePresent() {
        creditCardDetails = new ArrayList<>();
        when(creditCardService.getDetails()).thenReturn(creditCardDetails);
        ResponseEntity<List<CreditCard>> response = creditCardController.getAllCreditCardDetails();
        Assert.assertTrue(response.getStatusCode()== HttpStatus.OK);
        Assert.assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void shouldReturn20OResponsewithNonEmptyList_whenAccountsArePresent() {
        creditCardDetails = new ArrayList<>();
        creditCardDetails.add(CreditCard.builder().name("abc").cardNumber("").creditLimit(new BigDecimal(1200)).build());
        creditCardDetails.add(CreditCard.builder().name("john").cardNumber("").creditLimit(new BigDecimal(1000)).build());
        when(creditCardService.getDetails()).thenReturn(creditCardDetails);
        ResponseEntity<List<CreditCard>> response = creditCardController.getAllCreditCardDetails();
        Assert.assertTrue(response.getStatusCode()== HttpStatus.OK);
        Assert.assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void shouldReturn20OResponsewithSizeAs2_whenAccountsArePresent() {
        creditCardDetails = new ArrayList<>();
        creditCardDetails.add(CreditCard.builder().name("abc").cardNumber("").creditLimit(new BigDecimal(1200)).build());
        creditCardDetails.add(CreditCard.builder().name("john").cardNumber("").creditLimit(new BigDecimal(1000)).build());
        when(creditCardService.getDetails()).thenReturn(creditCardDetails);
        ResponseEntity<List<CreditCard>> response = creditCardController.getAllCreditCardDetails();
        Assert.assertTrue(response.getStatusCode()== HttpStatus.OK);
        Assert.assertEquals(2, response.getBody().size());
    }

}