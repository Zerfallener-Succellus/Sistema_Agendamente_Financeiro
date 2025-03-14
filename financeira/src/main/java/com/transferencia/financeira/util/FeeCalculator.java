package com.transferencia.financeira.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class FeeCalculator {

    public static BigDecimal calculateFee(LocalDate transferDate, BigDecimal amount) {
        long daysInAdvance = ChronoUnit.DAYS.between(LocalDate.now(), transferDate);

        if (daysInAdvance == 0) {
            return new BigDecimal("3.00").add(amount.multiply(new BigDecimal("0.025")));
        } else if (daysInAdvance <= 10) {
            return new BigDecimal("12.00");
        } else if (daysInAdvance <= 20) {
            return amount.multiply(new BigDecimal("0.082"));
        } else if (daysInAdvance <= 30) {
            return amount.multiply(new BigDecimal("0.069"));
        } else if (daysInAdvance <= 40) {
            return amount.multiply(new BigDecimal("0.047"));
        } else if (daysInAdvance <= 50) {
            return amount.multiply(new BigDecimal("0.017"));
        }

        throw new IllegalArgumentException("Taxa n~ao aplicvel a periodo de tempo.");
    }
}
