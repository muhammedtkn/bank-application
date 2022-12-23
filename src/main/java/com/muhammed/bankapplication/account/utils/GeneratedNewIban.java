package com.muhammed.bankapplication.account.utils;

import com.muhammed.bankapplication.general.enums.GenericErrorMessage;
import com.muhammed.bankapplication.general.exceptions.BusinessException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.StringUtils;

public class GeneratedNewIban {

    public static Long getRandomNumber(int charCount) {

        if (charCount <= 0) {
            throw new BusinessException(GenericErrorMessage.CHAR_COUNT_MUST_BE_POSITIVE);
        }

        if (charCount > 19) {
            throw new BusinessException(GenericErrorMessage.CHAR_COUNT_MUST_BE_LESS_THAN_19);
        }

        String numberAsString;
        do {
            numberAsString = getRandomNumberAsString(charCount);
        } while (numberAsString.startsWith("0"));

        Long randomNumber = null;
        if (StringUtils.hasText(numberAsString)) {
            randomNumber = Long.parseLong(numberAsString);
        }

        return randomNumber;
    }

    public static String getRandomNumberAsString(int charCount) {

        if (charCount < 0) {
            throw new BusinessException(GenericErrorMessage.CHAR_COUNT_MUST_BE_POSITIVE);
        }

        return RandomStringUtils.randomNumeric(charCount);
    }
}
