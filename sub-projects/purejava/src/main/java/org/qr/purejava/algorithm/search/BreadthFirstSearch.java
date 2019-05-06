package org.qr.purejava.algorithm.search;

import org.apache.commons.lang3.StringUtils;


import java.util.*;

/**
 * Grokking Algorithm - chapter 6
 *
 * 图, 广度优先算法
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        Map<String, String[]> diagramMap = initDiagramMap();
        Set<String> searched = new HashSet<>();

        String[] youArray = diagramMap.get("you");
        Queue<String> queueO = putInto(youArray);

        while (queueO.size() != 0) {
            String one = queueO.poll();
            System.out.println("Log the one --- : " + one);
            if (StringUtils.isEmpty(one) || searched.contains(one)) {
                continue;
            }

            if (isSeller(one)) {
                System.out.println("Found the seller: " + one);
                searched.add(one);

                return;  //
            } else {
                append(queueO, diagramMap.get(one));
                searched.add(one);
            }
        }
    }

    private static Map<String, String[]> initDiagramMap() {
        Map<String, String[]> map = new HashMap();
        String[] ofYou = {"alice", "bob", "claire"};
        String[] ofBob = {"anuj", "peggy"};
        String[] ofAlice = {"peggy"};
        String[] ofClaire = {"thom", "jonny"};
        String[] ofAnuj = {};

        map.put("you", ofYou);
        map.put("bob", ofBob);
        map.put("alice", ofAlice);
        map.put("claire", ofClaire);
        map.put("anuj", ofAnuj);
        map.put("peggy", ofAnuj);
        map.put("thom", ofAnuj);
        map.put("jonny", ofAnuj);
        return map;
    }

    private static boolean isSeller(String name) {
        return name.endsWith("m");
    }

    private static Queue<String> putInto(String[] arr) {
        if (isEmpty(arr)) {
            return null;
        }

        Queue queue = new ArrayDeque();
        for (String one : arr) {
            queue.add(one);
        }
        return queue;
    }

    private static boolean isEmpty(String[] arr) {
        return arr == null || arr.length == 0;
    }

    private static Queue<String> append(Queue<String> queue, String[] arr) {
        if (isEmpty(arr)) {
            return queue;
        }

        for (String one : arr) {
            queue.add(one);
        }
        return queue;
    }

}








