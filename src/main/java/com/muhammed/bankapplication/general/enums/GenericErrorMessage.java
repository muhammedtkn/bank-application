package com.muhammed.bankapplication.general.enums;

import com.muhammed.bankapplication.general.exceptions.BaseErrorMessage;

public enum GenericErrorMessage implements BaseErrorMessage {

    PARAMETER_CANNOT_BE_NULL("Parameter cannot be null"),
    ITEM_NOT_FOUND("Item not found!"),
    CHAR_COUNT_MUST_BE_POSITIVE("Char count must be positive!"),
    CHAR_COUNT_MUST_BE_LESS_THAN_19("Char count must be less than 19!")
    ;
   private String message;
    GenericErrorMessage(String message) {
     this.message=message;
    }
    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
