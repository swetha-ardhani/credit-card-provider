package com.sapient.creditcardprovider.exceptions;

public class CreditCardProviderException extends Exception {

    private static final long serialVersionUID = 4830151023350963831L;
    private static final String MESSAGE = "Invalid Data";
    private String extraMessage;

    public CreditCardProviderException() {
        super(MESSAGE);
    }

    public CreditCardProviderException(String message) {
        super(message);
    }

}
