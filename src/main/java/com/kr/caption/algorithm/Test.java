package com.kr.caption.algorithm;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.*;

public class Test {


    private static final Integer LIMIT_NUM = 20;

    private void subListSkill() {

        List<String> list = new ArrayList<>(100);

        if (list.size() > LIMIT_NUM) {
            int part = list.size() / LIMIT_NUM;
            for (int i = 0; i < part; i++) {
                List<String> taskBatchList = list.subList(0, LIMIT_NUM);
                //to do something
                list.subList(0, LIMIT_NUM).clear();
            }
        }

        if (list.size() > 0) {
            //to do something
            list.clear();
        }

    }


    public static void main(String[] args) {
        String log = "a 10:15\n" +
                "a 10:16\n" +
                "b 10:16\n" +
                "c 11:34\n" +
                "d 12:45";

        String[] s = log.split("\n");
        Map<String, Integer> map = new HashMap<>(16);
        HashSet<String> objects1 = new HashSet<>();
        for (String s1 : s) {
            objects1.add(s1.substring(0, s1.indexOf(":")));
        }

        for (String s2 : objects1) {
            String[] s3 = s2.split(" ");
            if (map.containsKey(s3[1])) {
                map.put(s3[1], map.get(s3[1]) + 1);
            } else {
                map.put(s3[1], 1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "----" + entry.getValue());
        }


       /*
        HashMap<String, Integer> objectMap = new HashMap<>();

        String[] s = log.split("\n");
        if (s.length < 1) {
            return;
        }

        HashSet<String> objects = new HashSet<>();
        for (String s1 : s) {
            String substring = s1.substring(0, s1.indexOf(":"));
            objects.add(substring);

        }

        for(String s1 :objects){
            String[] s3 = s1.split(" ");
            if (s3.length == 2) {
                if (objectMap.containsKey(s3[1])) {
                    objectMap.put(s3[1], objectMap.get(s3[1]) + 1);
                } else {
                    objectMap.put(s3[1], 1);
                }
                }

        }
*/

//        for (String s1 : s) {
//            String[] s2 = s1.split(" ");
//            if(s2.length == 2){
//                String s3 = s2[1];
//                String[] s4 = s3.split(":");
//                if(s4.length == 2){
//                    if(objectMap.containsKey(s4[0])){
//                        objectMap.put(s4[0], objectMap.get(s4[0]) + 1);
//                    }else{
//                        objectMap.put(s4[0], 1);
//                    }
//                }
//            }
//        }


     /*   Set<String> keySet = objectMap.keySet();
        for (String key : keySet) {
            System.out.println(key + "---------" + objectMap.get(key));
        }*/

        /*Set<Map.Entry<String, Integer>> entries = objectMap.entrySet();
        for(Map.Entry<String, Integer> entry:entries){
            System.out.println(entry.getKey() + "===" + entry.getValue());
        }*/
    }




}
