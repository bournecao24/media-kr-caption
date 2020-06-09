package com.kr.caption.algorithm.leetcode;


/**
 *
 * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
 *
 * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
 *
 * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
 *
 * 输入描述: 输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
 *
 * 输出描述: 输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
 *
 * 输入例子1: 10
 *
 * 输出例子1: 122
 */
public class Question6 {

    public static   void isPalindrome(int coinCount) {

        StringBuilder sb = new StringBuilder();
        while (coinCount >= 1) {
            // 偶数的情况
            if (coinCount % 2 == 0) {
                coinCount = (coinCount - 2) / 2;
                sb.append("2");
                // 奇数的情况
            } else {
                coinCount = (coinCount - 1) / 2;
                sb.append("1");
            }
        }
        // 输出反转后的字符串
        System.out.println(sb.reverse());
    }


    public static void main(String[] args) {
        int coinCount = 1;
        isPalindrome(coinCount);

    }
}
