package com.kr.caption.algorithm.leetcode;


/**
 *  斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。 n<=39
 */
public class Question8 {

    public static  int solution(int number) {

        if (number <= 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        int first = 1, second = 1, third = 0;
        for (int i = 3; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args) {
        int number = 8;
        int solution = solution(number);
        System.out.println(solution);
    }
}
