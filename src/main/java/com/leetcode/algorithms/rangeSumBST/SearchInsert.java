package com.leetcode.algorithms.rangeSumBST;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums.length ==0 ) {
            return 0;
        }

        if (nums[0] > target) {
            return 0;
        }
        if (nums[(nums.length -1)] < target) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target && nums[i+1] > target) {
                return ++i;
            }
        }
        return 0;
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (nums[length-1] < target || nums[0] > target || length > 10001 || length < 0){
            return -1;
        }

        int lo = 0;
        int hi = length-1;
        while (lo <= hi){
            int mid = lo + (hi -lo) / 2;
            if (target < nums[mid]){
                hi = mid-1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }
}
