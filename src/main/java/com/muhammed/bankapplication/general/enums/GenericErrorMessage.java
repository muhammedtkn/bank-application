package com.muhammed.bankapplication.general.enums;

import com.muhammed.bankapplication.general.exceptions.BaseErrorMessage;

public enum GenericErrorMessage implements BaseErrorMessage {

   ITEM_NOT_FOUND("Item not found")
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
