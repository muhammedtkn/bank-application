package com.muhammed.bankapplication.general.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralRestResponse<T> {

    private T data;
    private LocalDate responseDate;
    private boolean isSuccess;
    private String message;

    public GeneralRestResponse(T data, boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
    }

    public GeneralRestResponse(T data, boolean isSuccess,String message) {
        this.data = data;
        this.message=message;
        this.isSuccess = isSuccess;
    }


    public static <T>GeneralRestResponse<T> of(T t) {
        return new GeneralRestResponse<>(t,true);
    }

    public static <T>GeneralRestResponse<T> error(T t,String message) {
        return new GeneralRestResponse<>(t,false,message);
    }

    public static <T>GeneralRestResponse<T> empty() {
        return new GeneralRestResponse<>(null,true);
    }


}

