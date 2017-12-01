package com.dr.math;


import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class RandomDemo {

    public static void main(String[] args) {
//        int min = 1;
//        int max = 6;
//
//        for (int i = 0; i<20; i++) {
//            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
//            System.out.println(randomNum);
//        }

//        int toPoint = 0;
//        for (int i = 0; i<23; i++)
//            System.out.println(i + "----" + isPrizePoint(i));

//        Integer diceValue = 2;
//        if (diceValue < 1 || diceValue > 6) {
//
//            System.out.println("  error");
//        }


       // appendOverInfo();
//        for (int i = 0; i<20; i++) {
//            String orderNoOfFuiou = new RandomDemo().createOrderNoOfFuiou();
//            System.out.println(orderNoOfFuiou + ", " + orderNoOfFuiou.length());
//        }

        String amount = null;
        String scale = StringUtils.substringAfter(amount, ".");
        System.out.println(scale);
    }

    public String createOrderNoOfFuiou() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuffer buffer = new StringBuffer();

        buffer.append(sdf.format(date));

        Random rand = new Random();
        int length = 6;
        for (int i = 0; i < length; i++) {
            int tempvalue = rand.nextInt(10);
            buffer.append(tempvalue);
        }
        return buffer.toString();
    }

    private static boolean isPrizePoint(int toPoint) {
        if (toPoint <= 0) {
            return false;
        }
        return toPoint%10 == 0;
//        return toPoint> 0 && (toPoint == 10 || toPoint%10 == 0);
    }

    public static Date getTime(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(year, --month, day);
        gregorianCalendar.set(Calendar.HOUR_OF_DAY, hour);
        gregorianCalendar.set(Calendar.MINUTE, minute);
        gregorianCalendar.set(Calendar.SECOND, second);
        gregorianCalendar.set(Calendar.MILLISECOND, millisecond);
        return gregorianCalendar.getTime();
    }

    private static void appendOverInfo() {
        Date overTime = getTime(2017, 2, 28, 23, 59, 59, 99);
        Date now = new Date();

//        if (now.after(overTime)) {

            int investedAmountInt = 90070;
            int gotCardCount = 0;
                gotCardCount = investedAmountInt/THREHOLD;
            System.out.println(gotCardCount);
//        }
    }

    private static final int THREHOLD = 30000;

}
