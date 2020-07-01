package com.kr.caption.algorithm.leetcode;


import com.kr.caption.algorithm.support.ListNode;

import java.util.HashSet;


public class Question4 {


    /**
     * * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。
     * * 回文串：“回文串”是一个正读和反读都一样的字符串，比如 “level” 或者 “noon” 等等就是回文串。
     **/
    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashSet<Character> hashSet = new HashSet<>();
        int count = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (!hashSet.contains(charArray[i])) {
                hashSet.add(charArray[i]);
            } else {
                hashSet.remove(charArray[i]);
                count++;
            }
        }

        return hashSet.isEmpty() ? count * 2 : count * 2 + 1;
    }


    /**
     * 排序数组，删除重复出现的元素返回排重之后的新长度
     * <p>
     * 由于数组已经排序，所以重复的元素一定连在一起，找出它们并不难，但如果毎找到一个重复元素就立即删除它，就是在数组中间进行删除操作，整个时间复杂度是会达到 O(N^2)
     * 而且题目要求我们原地修改，也就是说不能用辅助数组，空间复杂度得是 O(1)
     * 对于数组相关的算法问题，有一个通用的技巧：要尽量避免在中间删除元素，那我就想先办法把这个元素换到最后去。这样的话，最终待删除的元素都拖在数组尾部，一个一个 pop 掉就行了，每次操作的时间复杂度也就降低到 O(1) 了
     *
     * 快慢指针 思想：我们让慢指针 slow 走左后面，快指针 fast 走在前面探路，找到一个不重复的元素就告诉 slow 并让 slow 前进一步。这样当 fast 指针遍历完整个数组 nums 后，nums[0..slow] 就是不重复元素，之后的所有元素都是重复元素
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 1;

        while (fast < length) {

            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0...slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return  slow + 1;

    }

    /**
     * 去重链表中的重复元素
     * @return
     */
    public ListNode removeDuplicates(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null){
            if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }

        // 断开与后面重复元素的连接
        slow.next = null;

        return head;
    }


    public static void main(String[] args) {
        String[] strs = {"customer", "car", "cat"};

    }
}
