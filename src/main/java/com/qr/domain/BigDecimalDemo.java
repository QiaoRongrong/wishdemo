package com.qr.domain;

import java.math.BigDecimal;

public class BigDecimalDemo {

    private static final int THREHOLD = 30000;
    public static int getToMatchAmount(BigDecimal investedAmount) {
        int investedAmountInt = investedAmount.intValue();

        if (investedAmountInt == 0) {
            return THREHOLD;
        }

        int result = investedAmountInt / THREHOLD;
        if (result == 0) {
            return THREHOLD - investedAmountInt;
        } else if (result > 0) {
            return (++result * THREHOLD) - investedAmountInt;
        }
        return result;
    }

    public static void main(String[] args) {
        BigDecimal input = BigDecimal.valueOf(1230);
        System.out.println(getToMatchAmount(input));

         input = BigDecimal.valueOf(21230);
        System.out.println(getToMatchAmount(input));

         input = BigDecimal.valueOf(31230);
        System.out.println(getToMatchAmount(input));

         input = BigDecimal.valueOf(101230);
        System.out.println(getToMatchAmount(input));
    }
}
