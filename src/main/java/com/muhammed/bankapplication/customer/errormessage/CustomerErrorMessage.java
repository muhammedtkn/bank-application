package com.muhammed.bankapplication.customer.errormessage;

import com.muhammed.bankapplication.general.exceptions.BaseErrorMessage;

public enum CustomerErrorMessage implements BaseErrorMessage {
    WRONG_OLD_PASSWORD("Wrong old password!"),
    NEW_PASSWORDS_DID_NOT_MATCH("New passwords did not match")

    ;
    private String message;
    CustomerErrorMessage(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
