package com.muhammed.bankapplication.sec.errormessage;

import com.muhammed.bankapplication.general.exceptions.BaseErrorMessage;

public enum SecurityErrorMessage implements BaseErrorMessage {

    USERNAME_CANNOT_BE_NULL("Username cannot be null!"),
    USERNAME_MUST_BE_NUMBER("Username must be number"),
    INVALID_USERNAME_AND_PASSWORD("Invalid username and password")
    ;

    private String message;

    SecurityErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

}
