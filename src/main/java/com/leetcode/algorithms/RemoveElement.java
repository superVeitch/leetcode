package com.leetcode.algorithms;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]){
                nums[j] = nums[i];
                ++j;
            }
        }
        return j;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3};
        int len = removeElement(a, 3);
        for (int i = 0; i < len; i++) {
            System.out.println(a[i]);
        }
    }
}
