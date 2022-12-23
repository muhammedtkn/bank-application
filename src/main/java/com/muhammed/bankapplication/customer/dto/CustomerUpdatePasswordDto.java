package com.muhammed.bankapplication.customer.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerUpdatePasswordDto {

    @NotBlank
    private  String oldPassword;

    @NotNull
    @Size(min=6)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]) (?=.*[A-Z])")
    private  String newPassword;
    @NotNull
    @Size(min=6)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]) (?=.*[A-Z])")
    private  String newPasswordAgain;


}
