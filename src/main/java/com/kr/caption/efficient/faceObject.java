package com.kr.caption.efficient;

public class faceObject {

    public static void listParam(Object... args){
        System.out.println(args.length);
    }

    /**
     * 可变参数
     * 使用Object作为参数的时候，过于灵活，类型转换场景不好预判
     * @param args
     */
    public static void main(String[] args) {
        listParam(1,2,3);    //3
        listParam(new int[]{1,2,3});    //1
        listParam(3, new String[]{"1", "2"});   //2
        listParam(new Integer [] {2,3,2});   //3
        listParam(3, new Integer [] {2,3,2});   //2

        //Integer [] 可以作为一个Object[]，也可以作为一个Object， 而int[] 只能作为一个Object

    }

}
