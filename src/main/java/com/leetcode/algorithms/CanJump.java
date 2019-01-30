package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanJump {
    public static boolean canJump(int[] nums) {
        if (nums.length <= 1){
            return true;
        }
        if (nums[0] == 0){
            return false;
        }
        // 贪心算法 获取每一点能达到的最大位置
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i=1; i<nums.length-1; i++){
            dp.add(Math.max(nums[i], dp.get(i-1)-1));
            if (dp.get(i)+i >= nums.length-1) {
                return true;
            } else if (dp.get(i) == 0 && i<nums.length-1){
                return false;
            }
        }
        return true;
    }

    public static boolean canJump1(int[] nums) {
        if (nums.length <= 1){
            return true;
        }
        if (nums[0] == 0){
            return false;
        }

        int step = 0;
        int i = 0;
        while (i <= step && i < nums.length) {
            step = Math.max(step, nums[i]+i);
            ++i;
        }
        if (step>=nums.length-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] i = new int[]{3,2,1,0,4};
        System.out.println(canJump(i));
    }
}
