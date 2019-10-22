package org.qr.purejava.datastructure;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * 1. array 2. hash function 3. conflict - use linked list
 */
public class JoryHashTable {

    private Object[] tableArray = new Object[10];

    int size(){
        int size = 0;
        for (Object object : tableArray) {
            if (object != null) {
                List<Entity> bucket = (List) object;
                size += bucket.size();
            }
        }

        return size;
    }

    Object get(Object key) {
        int hashValue = hash(key);
        System.out.println("=======" + hashValue);
        if (tableArray[hashValue] == null) {
            return null;
        }
        List<Entity> bucket = (List) tableArray[hashValue];
        if (bucket == null || bucket.size() == 0) {
            return null;
        }

        for (Entity entity : bucket) {
            if (entity.getKey().equals(key)) {
                return entity.getValue();
            }
        }

        return null;
    }

    void put(Object key, Object value) {
        int hashValue = hash(key);

        Entity entity = new Entity(key, value);
        if (tableArray[hashValue] == null) {

            List<Object> bucket = new LinkedList<>();
            bucket.add(entity);

            tableArray[hashValue] = bucket;
        } else {
            List<Object> bucket = (List) tableArray[hashValue];
            bucket.add(entity);
        }

    }

    static int hash(Object object) {
        return Math.abs(object.hashCode() % 10);
    }

    @Data
    @AllArgsConstructor
    class Entity {
        private Object key;
        private Object value;
    }

}
