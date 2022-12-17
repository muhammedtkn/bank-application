package com.muhammed.bankapplication.general.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundExeption extends BusinessException{

    public ItemNotFoundExeption(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
