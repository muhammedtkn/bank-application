package com.muhammed.bankapplication.general.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class GeneralExeptionResponse {

    private String message;
    private String detail;
    private LocalDateTime dateTime;
}
