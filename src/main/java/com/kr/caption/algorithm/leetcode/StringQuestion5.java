package com.kr.caption.algorithm.leetcode;


import java.util.*;

/**
 *
 */
public class StringQuestion5 {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {    // 字符不是字母和数字的情况
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {    // 字符不是字母和数字的情况
                r--;
            } else {  // 判断二者是否相等
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }


    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串   返回 s 所有可能的分割方案
     * 输入: "aab"
     * 输出:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * <p>
     * 既然需要将所有的分割方法都找出来，那么肯定需要用到DFS（深度优先搜索）或者BFS（广度优先搜索）, 在处理的时候去优先寻找更短的回文串，然后回溯找稍微长一些的回文串分割方法，不断回溯，分割，直到找到所有的分割方法
     * ]
     */
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> partition(String s) {
            if (s == null || s.length() == 0)
                return res;
            dfs(s, new ArrayList<String>(), 0);
            return res;
        }

        public void dfs(String s, List<String> remain, int left) {
            if (left == s.length()) {  //判断终止条件
                res.add(new ArrayList<String>(remain));  //添加到结果中
                return;
            }
            for (int right = left; right < s.length(); right++) {  //从left开始，依次判断left->right是不是回文串
                if (isPalindroom(s, left, right)) {  //判断是否是回文串
                    remain.add(s.substring(left, right + 1));   //添加到当前回文串到list中
                    dfs(s, remain, right + 1);  //从right+1开始继续递归，寻找回文串
                    remain.remove(remain.size() - 1);  //回溯，从而寻找更长的回文串
                }
            }
        }

        /**
         * 判断是否是回文串
         */
        public boolean isPalindroom(String s, int left, int right) {
            while (left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            return left >= right;
        }
    }


    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * <p>
     * 说明：
     * <p>
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     */
    class WordDictSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            int max_length = 0;
            for (String temp : wordDict) {
                max_length = temp.length() > max_length ? temp.length() : max_length;
            }
            // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
            boolean[] memo = new boolean[n + 1];
            memo[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = i - 1; j >= 0 && max_length >= i - j; j--) {
                    if (memo[j] && wordDict.contains(s.substring(j, i))) {
                        memo[i] = true;
                        break;
                    }
                }
            }
            return memo[n];
        }
    }


    /**
     * 反转字符串
     *
     * @param s
     */
    private static void reverseString(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        char k;
        while (i < j) {
            k = chars[i];
            chars[i] = chars[j];
            chars[j] = k;

            i++;
            j--;

        }

        String result = Arrays.toString(chars);
        System.out.println(result);

    }


    /**
     * 将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数
     *
     * @param str
     * @return
     */
    private int strToInt(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }

            if (c < '0' || c > '9') {
                return 0;
            }
            ret = ret * 10 + (c - '0');

        }
        return isNegative ? -ret : ret;
    }


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""
     *
     * @param strs
     * @return
     */
    public static String replaceSpace(String[] strs) {

        // 如果检查值不合法及就返回空串
        if (!checkStrs(strs)) {
            return "";
        }
        // 数组长度
        int len = strs.length;
        // 用于保存结果
        StringBuilder res = new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strs);

        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);

        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else
                break;

        }
        return res.toString();

    }

    private static boolean checkStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            // 遍历strs检查元素值
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }


    /**
     * * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的  最长的回文串
     * <p>
     * 在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。
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
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
     *
     * @param str
     * @return
     */
    public String replaceSpace(String str) {
        StringBuffer buffer = new StringBuffer();
        int len = str.length() - 1;

        for (int i = len; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                buffer.append("02%");
            } else {
                buffer.append(str.charAt(i));
            }
        }
        return buffer.toString();
    }


    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000
     */
    private int index, len;

    public String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            palindromeHelper(s, i, i);
            palindromeHelper(s, i, i + 1);
        }

        return s.substring(index, index + len);
    }

    public void palindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }


    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 换句话说，第一个字符串的排列之一是第二个字符串的子串
     * <p>
     * 不用真的去算出s1的全排列，只要统计字符出现的次数即可。可以使用一个哈希表配上双指针来做
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] count = new int[128];
        if (l1 > l2)
            return false;
        for (int i = 0; i < l1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count))
            return true;
        for (int i = l1; i < l2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - l1) - 'a']++;
            if (allZero(count))
                return true;
        }
        return false;
    }

    public boolean allZero(int[] count) {
        int l = count.length;
        for (int i = 0; i < l; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }


    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
     * <p>
     * 把问题拆解成简单的步骤：
     * 第一步求所有可能出现在第一个位置的字符（即把第一个字符和后面的所有字符交换[相同字符不交换]）；
     * 第二步固定第一个字符，求后面所有字符的排列。这时候又可以把后面的所有字符拆成两部分（第一个字符以及剩下的所有字符），依此类推。这样，我们就可以用递归的方法来解决。
     */
    List<String> res = new ArrayList<String>();

    public List<String> Permutation(String str) {
        if (str == null) {
            return res;
        }
        PermutationHelper(str.toCharArray(), 0);
        Collections.sort(res);
        return res;
    }

    public void PermutationHelper(char[] str, int i) {
        if (i == str.length - 1) {
            res.add(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                if (j != i && str[i] == str[j]) {
                    continue;
                }
                swap(str, i, j);
                PermutationHelper(str, i + 1);
                swap(str, i, j);
            }
        }
    }

    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1
     *
     * 先在hash表中统计各字母出现次数，第二次扫描直接访问 hash 表获得次数。也可以用数组代替 hash 表
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {

        int len = str.length();
        if (len == 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(str.charAt(i))){
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }

        for(int i = 0; i < len; i++){
            if(map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }


    /**
     * 翻转单词顺序列
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if(s.trim().length() == 0)
            return s.trim();
        String [] temp = s.trim().split(" +");
        String res = "";
        for(int i = temp.length - 1; i > 0; i--){
            res += temp[i] + " ";
        }
        return res + temp[0];
    }


    /**
     * 给定两个字符串, A 和 B。 A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True
     *
     * @param A
     * @param B
     * @return
     */
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A+A).contains(B);
    }







    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
//        System.out.println(Question5.isPalindrome(str));


        StringQuestion5.reverseString("12345678");


    }
}
