package com.dr.commondemo;

import java.math.BigDecimal;

/**
 * Created by qiaor on 19/01/2017.
 */
public class BigDecimalUtils {

    public static void main(String[] args) {
        BigDecimal value = BigDecimal.valueOf(387.54321000);
        System.out.println(value);
        System.out.println(value.setScale(2, BigDecimal.ROUND_DOWN));
    }
}
