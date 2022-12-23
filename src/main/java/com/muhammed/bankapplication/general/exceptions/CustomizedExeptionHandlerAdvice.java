package com.muhammed.bankapplication.general.exceptions;

import com.muhammed.bankapplication.general.response.GeneralExeptionResponse;
import com.muhammed.bankapplication.general.response.GeneralRestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class CustomizedExeptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest){

        GeneralRestResponse response = initGeneralRestResponse(exception, webRequest);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleBusinessException(BusinessException exception,WebRequest webRequest){

        GeneralRestResponse response = initGeneralRestResponse(exception, webRequest);

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleItemNotFoundExceptions(BusinessException exception,WebRequest webRequest){

        GeneralRestResponse response = initGeneralRestResponse(exception, webRequest);

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    private static GeneralRestResponse initGeneralRestResponse(Exception exception, WebRequest webRequest) {
        String message = exception.getMessage();
        String description = webRequest.getDescription(false);
        LocalDateTime now=LocalDateTime.now();

        GeneralExeptionResponse generalExeptionResponse=new GeneralExeptionResponse(message,description,now);
        GeneralRestResponse response=GeneralRestResponse.error(generalExeptionResponse,message);
        return response;
    }
}
