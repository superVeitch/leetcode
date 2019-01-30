package com.leetcode.algorithms;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf1(int[] nums) {
        int[] re = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int t = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j){
                    continue;
                }
                t = nums[j] * t;
            }
            re[i] = t;
        }
        return re;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] re = new int[nums.length];
        int i = 0;
        while (true){
            int t = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j){
                    continue;
                }
                t = nums[j] * t;
            }
            re[i] = t;
            if (i == nums.length-1){
                break;
            }
            ++i;
        }
        return re;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] re = new int[nums.length];
        int len = nums.length;
        int left = 1, right=1;
        for (int i = 0; i < nums.length; i++) {
            re[i] = left;
            left *= nums[i];
        }

        for (int i = (len-1); i >=0 ; i--) {
            re[i] *= right;
            right *= nums[i];
        }
        return re;
    }
    public static void main(String[] args) {
        int[] i = new int[]{2,3,4,5};
        int[] n = productExceptSelf(i);
        for (int j = 0; j < n.length; j++) {
            System.out.println(n[j]);
        }
    }
}
