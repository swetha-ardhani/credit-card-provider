package com.sapient.creditcardprovider.controller;

import com.sapient.creditcardprovider.dao.CreditCard;
import com.sapient.creditcardprovider.dto.CreditCardProviderRequest;
import com.sapient.creditcardprovider.dto.CreditCardProviderResponse;
import com.sapient.creditcardprovider.service.CreditCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @PostMapping("/Add")
    public ResponseEntity<CreditCardProviderResponse> addCreditCardDetails(@RequestBody CreditCardProviderRequest creditCardProviderRequest) {
        CreditCardProviderResponse response = creditCardService.addDetails(creditCardProviderRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/Get all")
    public ResponseEntity<List<CreditCard>> getAllCreditCardDetails() {
        List<CreditCard> creditCardList = creditCardService.getDetails();
        return new ResponseEntity<>(creditCardList, HttpStatus.OK);
    }
}
