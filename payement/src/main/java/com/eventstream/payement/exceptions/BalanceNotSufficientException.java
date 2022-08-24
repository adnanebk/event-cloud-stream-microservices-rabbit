package com.eventstream.payement.exceptions;

public class BalanceNotSufficientException extends RuntimeException {

    public BalanceNotSufficientException(String message) {
        super(message);
    }
}
