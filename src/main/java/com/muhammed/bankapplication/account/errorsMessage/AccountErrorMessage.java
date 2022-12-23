package com.muhammed.bankapplication.account.errorsMessage;

import com.muhammed.bankapplication.general.exceptions.BaseErrorMessage;

public enum AccountErrorMessage implements BaseErrorMessage {

    ACCOUNT_ALREADY_PASSIVE("This account is already passive!"),
    INSUFFICIENT_BALANCE("Insufficient balance!")
    ;
    private String message;

    AccountErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
