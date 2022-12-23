package com.muhammed.bankapplication.customer.sevice;

import com.muhammed.bankapplication.customer.dto.CustomerUpdatePasswordDto;
import com.muhammed.bankapplication.customer.errormessage.CustomerErrorMessage;
import com.muhammed.bankapplication.general.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class CustomerPasswordValidator {

   public void validatorPassword(CustomerUpdatePasswordDto customerUpdatePasswordDto,String password){

       String oldPassword= customerUpdatePasswordDto.getOldPassword();
       String newPassword= customerUpdatePasswordDto.getNewPassword();
       String newPassswordAgain= customerUpdatePasswordDto.getNewPasswordAgain();

       if(!password.equals(oldPassword)){
           throw new BusinessException(CustomerErrorMessage.WRONG_OLD_PASSWORD);
       }
       if(!newPassword.equals(newPassswordAgain)){
           throw new BusinessException(CustomerErrorMessage.WRONG_OLD_PASSWORD);
       }
   }

}
