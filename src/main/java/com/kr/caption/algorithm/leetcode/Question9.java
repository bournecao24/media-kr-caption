package com.kr.caption.algorithm.leetcode;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: caozhenlong
 * @Date: 8/16/21
 * @Description:
 */
public class Question9 {

    /**
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public static Integer removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }


    public static void main(String[] args) {
        int [] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Integer result = removeDuplicates(nums);
        System.out.println(result + "数组：" + JSONObject.toJSONString(nums));
    }
}
