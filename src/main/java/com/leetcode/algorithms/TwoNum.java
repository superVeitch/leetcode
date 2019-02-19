package com.leetcode.algorithms;

public class TwoNum {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= target){
                return new int[]{};
            }
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
