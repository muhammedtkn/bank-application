package com.muhammed.bankapplication.sec.dto;

import lombok.Data;

@Data
public class LoginRequestDto {

    private Long identityNo;
    private String password;
}
