package org.qr.purejava.datastructure;

import org.junit.Test;

public class JoryHashTableTest {

    @Test
    public void test() {
//        int lucy = new String("lucy").hashCode();
//        System.out.println(lucy % 10);

        JoryHashTable map1 = new JoryHashTable();
        map1.put("jack", 20);
        map1.put("rose", 18);
        map1.put("lucy", 17);
        map1.put("java", 25);

        System.out.println(map1.size());
        System.out.println(map1.get("jack"));
        System.out.println(map1.get("java"));
        System.out.println(map1.get("javaee"));
    }

}
