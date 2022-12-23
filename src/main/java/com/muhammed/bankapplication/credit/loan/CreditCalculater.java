package com.muhammed.bankapplication.credit.loan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCalculater {

    final static double interestRate= 1;

    public static BigDecimal loanCalculator(BigDecimal requestedLoan, Long numberOfInstallments ){

        BigDecimal installmentAmount;
        double doubleCalculatorOne=interestRate*(Math.pow((interestRate+1),numberOfInstallments));
        double doubleCalculatorTwo  = Math.pow((interestRate+1),numberOfInstallments)-1;

        BigDecimal calculatorOne=BigDecimal.valueOf(doubleCalculatorOne);
        BigDecimal calculatorTwo=BigDecimal.valueOf(doubleCalculatorTwo);

        installmentAmount=requestedLoan.multiply(calculatorOne.divide(calculatorTwo,2, RoundingMode.DOWN));


        return installmentAmount;


    }
}
