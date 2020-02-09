package org.qr.purejava.algorithm.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 快速排序
 *  https://github.com/egonSchiele/grokking_algorithms/tree/master/04_quicksort/java
 */

public class QuickSortInJava {

    private static List<Integer> quickSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        } else {
            Integer pivot = list.get(0);

            //sub-array of all the elements less than the pivot
            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot).collect(Collectors.toList());

            //sub-array of all the elements greater than the pivot
            List<Integer> greater = list.stream().skip(1).filter(el -> el> pivot).collect(Collectors.toList());

            return Stream.of(
                    quickSort(less).stream(),
                    Stream.of(pivot),
                    quickSort(greater).stream()
            ).flatMap(Function.identity())
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        List<Integer> sort = quickSort(Arrays.asList(138, 22, 34, 461, 5, 67, 7, 81, 9, 101));
        System.out.println(sort);
    }
}
