package org.qr.purejava.datastructure;

public class HashTableLearning {

    public static void main(String[] args) {
//        System.out.println(16 >> 4);
//        System.out.println(32 >>> 8);

        String key = "lucy jj";
        int h;
        int result = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);


        System.out.println(result);
    }


}
