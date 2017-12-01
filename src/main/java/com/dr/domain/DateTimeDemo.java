package com.dr.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

/**
 * Created by qiaor on 1/6/17.
 */
public class DateTimeDemo {

    public static void main(String[] args) {

        Date now = getSpecifiedTimeOfTocay(8, 0, 0, 0);

        System.out.println(now+ " -- " + now.toLocaleString());
    }


    public static Date getSpecifiedTimeOfTocay(int hour, int minute, int second, int millisecond) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.HOUR_OF_DAY, hour);
        gregorianCalendar.set(Calendar.MINUTE, minute);
        gregorianCalendar.set(Calendar.SECOND, second);
        gregorianCalendar.set(Calendar.MILLISECOND, millisecond);
        return gregorianCalendar.getTime();
    }
}
