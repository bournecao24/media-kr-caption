package com.kr.caption.algorithm.leetcode;

import com.kr.caption.algorithm.support.ListNode;

public class Question2 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);

        //将当前节点初始化为头结点，p和q也初始化为头部
        ListNode p = l1, q = l2, curr = headNode;

        //进位carry初始化为0
        int carry = 0;

        while (p != null || q != null) {

            //将x和y分别设置为p和q的值，如果到了末尾，就设置为0
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;

            // 求和
            int sum = carry + x + y;
            //更新进位的值
            carry = sum / 10;

            //新建一个结点，数值为 sum % 10？？？将其设置为当前节点的下一个结点，然后将当前节点前进到下一个结点
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            //同时将p和q前进到下一个结点
            if (p != null) p = p.next;
            if (q != null) q = q.next;

        }

        //检查下 进位是不是为1，如果为1，就在列表的最后加一个新节点
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        //我们初始化头结点的目的是简化代码，如果没有头结点，必须编写额外的条件语句来初始化头结点的值
        return headNode.next;

    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNodeI = new ListNode(5);
        ListNode listNodeII = new ListNode(6);
        ListNode listNodeIII = new ListNode(4);

        listNodeI.next = listNodeII;
        listNodeII.next = listNodeIII;

        ListNode listNodeResult = addTwoNumbers(listNode, listNodeI);


        System.out.println(listNodeResult);


    }
}
