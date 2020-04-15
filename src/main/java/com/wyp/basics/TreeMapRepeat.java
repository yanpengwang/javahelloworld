package com.wyp.basics;

import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapRepeat {
    public static void main(String[] args) {
        //TreeMap map = new TreeMap();
        HashMap map = new HashMap();
        Key key1 = new Key();
        Key key2 = new Key();
        map.put(key1, "one");
        map.put(key2, "two");
        System.out.println("map.size() = " + map.size());        
    }
}

class Key implements Comparable<Key> {
    @Override
    public int compareTo(Key other){
        return -1;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
