package org.qr.purejava.algorithm.graph;

import java.util.*;

/**
 * graph:
 *  https://github.com/egonSchiele/grokking_algorithms/blob/master/06_breadth-first_search/java/01_breadth_first_search/src/BreadthFirstSearch.java
 *
 */
public class BreadthFirstSearch {

    private static Map<String, List<String>> graph = new HashMap<>();

    private static boolean search(String name) {
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name));

        List<String> searched = new ArrayList<>();

        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();

            //Only search this person if you haven't already searched them.
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    searchQueue.addAll(graph.get(person));
                    //Mark this person as searched
                    searched.add(person);
                }
            }
        }

        return false;
    }

    private static boolean personIsSeller(String name) {
        return name.endsWith("m");
    }

    public static void main(String[] args) {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());


        search("you");

    }
}

