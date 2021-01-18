package com.sapient.creditcardprovider.dto;

import lombok.Data;

@Data
public class ErrorMessage {

    private String httpCode;

    private String httpMessage;

    private String message;

}
