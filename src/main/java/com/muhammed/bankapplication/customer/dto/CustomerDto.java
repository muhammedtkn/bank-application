package com.muhammed.bankapplication.customer.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
@Data
public class CustomerDto {

    private Long id;
    @NotBlank
    @Size(min=3,max = 30)
    private  String name;

    @NotBlank
    @Size(min=3,max = 30)
    private  String surname;

    @NotNull
    @Positive
    private  Long identiyNo;

    @NotNull
    @Size(min=6)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]) (?=.*[A-Z])")
    private  String password;

}
