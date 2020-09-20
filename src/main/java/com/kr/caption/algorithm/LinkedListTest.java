package com.kr.caption.algorithm;

import com.kr.caption.algorithm.lru.Node;

import java.util.*;

public class LinkedListTest {


    /**
     * 从头到尾打印链表
     *
     * @param node
     */
    public static void fromTailToHead(Node node) {

        Stack<Node> stack = new Stack<>();

        Node head = node;

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (stack.size() > 0) {
            Node top = stack.pop();
            System.out.println(top.val);
        }
    }


    /**
     * 字符串中字母出现的次数并排序输出
     */
    public static void printStrShowNumber() {

        String str = "abdklie;ljkdfksjfdsfjdkslljslfjksjgkjgl";
        Map<Character, Integer> strMap = new HashMap<>();

        char[] charArray = str.toCharArray();
        for (char ch : charArray) {

            if (strMap.containsKey(ch)) {
                strMap.put(ch, strMap.get(ch) + 1);
            } else {
                strMap.put(ch, 1);
            }
        }

        List<KeyValue> objects = new ArrayList<>();
        Set<Map.Entry<Character, Integer>> entries = strMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            KeyValue keyValue = new KeyValue();
            keyValue.setCount(entry.getValue());
            keyValue.setStr(entry.getKey().toString());

            objects.add(keyValue);
        }

        objects.sort(Comparator.comparing(KeyValue::getCount));

        for (KeyValue keyValue : objects) {
            System.out.println("字符" + keyValue.getStr() + "字符出现次数=" + keyValue.getCount());
        }

    }

    public static class KeyValue {
        private Integer count;
        private String str;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }


    /**
     * 字符串中字母出现的次数并排序输出V2
     */
    private static void printStrShowNumberV2() {
        String str = "abdklie;ljkdfksjfdsfjdkslljslfjksjgkjgl";

        ArrayList<Character> array = new ArrayList<Character>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //--------这里是计算字符出现次数并记录↓----------
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (map.containsKey(tmp)) {
                int num = map.get(tmp);
                num++;
                map.put(tmp, num);
            } else {
                map.put(tmp, 1);
                array.add(tmp);
            }
        }
        //-----下面就是个冒泡--------
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - 1 - i; j++) {
                if (map.get(array.get(j)) > map.get(array.get(j + 1))) {
                    char tmp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, tmp);
                }
            }
        }
        System.out.println(map);//这个就是打印字符出现的次数
        System.out.println(array);//这个打印排序后的数组,从小到大
    }

    /**
     * 字符串中出现次数最多的
     */
    private static void printStrShowMax() {
        String str = "abdklie;ljkdfksjfdsfjdkslljslfjksjgkjgl";

        ArrayList<Character> array = new ArrayList<Character>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //--------这里是计算字符出现次数并记录↓----------
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (map.containsKey(tmp)) {
                int num = map.get(tmp);
                num++;
                map.put(tmp, num);
            } else {
                map.put(tmp, 1);
                array.add(tmp);
            }
        }
        //-----下面就是个冒泡--------
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - 1 - i; j++) {
                if (map.get(array.get(j)) > map.get(array.get(j + 1))) {
                    char tmp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, tmp);
                }
            }
        }
        System.out.println(map);//这个就是打印字符出现的次数
        System.out.println(array);//这个打印排序后的数组,从小到大
    }


    public static void main(String[] args) {
        Node node = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        node.val = 3;
        node1.val = 4;
        node2.val = 5;
        node3.val = 6;

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        fromTailToHead(node);

        printStrShowNumber();
        printStrShowNumberV2();


    }


}
