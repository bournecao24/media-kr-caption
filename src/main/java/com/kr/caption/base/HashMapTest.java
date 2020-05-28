package com.kr.caption.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    private static final Map<Integer, String> map = new HashMap<>();

    private void iteratorMapV1(){
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
    }

    private void iteratorMapV2(){
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
            System.out.println(map.get(next));
        }
    }


    private void iteratorMapV3(){
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }


    private void iteratorMapV4(){
        for(Integer entry:map.keySet()){
            System.out.println(entry);
            System.out.println(map.get(entry));
        }
    }

    private void iteratorMapV5(){
        map.forEach((key, value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }


    private void iteratorMapV6(){
        map.forEach((key, value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }






}
