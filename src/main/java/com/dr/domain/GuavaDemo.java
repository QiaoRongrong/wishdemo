package com.dr.domain;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Random;

public class GuavaDemo {

    public static void main(String[] args) {
        System.out.println(calculateGoldcoin(50000));
        System.out.println(calculateGoldcoin(51000));

        System.out.println(calculateGoldcoin(90000));
        System.out.println(calculateGoldcoin(120000));
        System.out.println(calculateGoldcoin(160200));


//        Integer min = 100;
//        Integer max = 200;
//
//        for (int i= 0; i<100; i++) {
//            Integer result = GuavaDemo.randomTenDigitBetween(min, max);
////            if (result >= max)
//                System.out.print(result + " ");
//        }


    }

    private static Integer calculateGoldcoin(Integer investAmount) {

        if (investAmount == 50000) {
            return 10000;
        } else if (investAmount > 50000) {
            return investAmount / 50000 * 10000;
        } else {
            return 0;
        }
    }


    public static Integer randomTenDigitBetween(Integer min, Integer max) {
        return randomBetween(min, max) / 10 * 10;
    }

    public static Integer randomBetween(Integer min, Integer max) {
        if (min == null || max == null || min > max) {
            return -1;
        }
        if (max == min) {
            return max;
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }


    public static void templateOfguava() {
        ArrayList<CommonPojo> list = Lists.newArrayList();

        FluentIterable.from(list).filter(new Predicate<CommonPojo>() {
            @Override
            public boolean apply(CommonPojo input) {
                return false; //age >=30
            }
        }).toList();

        FluentIterable.from(list).transform(new Function<CommonPojo, CommonPojo>() {
            @Override
            public CommonPojo apply(CommonPojo input) {
                return null;
            }
        }).toList();

        FluentIterable.from(list).last();
        FluentIterable.from(list).limit(6);
        Optional<CommonPojo> optional = Iterables.tryFind(list, new Predicate<CommonPojo>() {
            @Override
            public boolean apply(CommonPojo input) {
                return false;
            }
        });

        Iterables.indexOf(list, new Predicate<CommonPojo>() {
            @Override
            public boolean apply(CommonPojo input) {
                return false;
            }
        });

        Iterables.limit(list, 5);
    }
}
