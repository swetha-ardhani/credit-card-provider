package com.sapient.creditcardprovider.controller;

import com.sapient.creditcardprovider.dao.CreditCard;
import com.sapient.creditcardprovider.dto.CreditCardProviderRequest;
import com.sapient.creditcardprovider.dto.CreditCardProviderResponse;
import com.sapient.creditcardprovider.exceptions.CreditCardProviderException;
import com.sapient.creditcardprovider.service.CreditCardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @ApiOperation(value = "Create Credit Card Account", nickname = "AddCreditCardAccounts", response = CreditCardProviderResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Credit Card Account Created", response = CreditCardProviderResponse.class),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping(value = "/Add",
            produces = {"application/json; charset=utf-8"},
            consumes = {"application/json; charset=utf-8"}
    )
    public ResponseEntity<CreditCardProviderResponse> addCreditCardDetails(@Valid @RequestBody CreditCardProviderRequest creditCardProviderRequest) throws CreditCardProviderException {
        CreditCardProviderResponse response = creditCardService.addDetails(creditCardProviderRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Credit Card Details", nickname = "getCreditCardDetails")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Credit Card Details")})

    @GetMapping("/Get all")
    public ResponseEntity<List<CreditCard>> getAllCreditCardDetails() {
        List<CreditCard> creditCardList = creditCardService.getDetails();
        return new ResponseEntity<>(creditCardList, HttpStatus.OK);
    }
}
