package com.leetcode.algorithms;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口最大值。
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  注意：你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 */

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[]{};
        }
        int slow = 0, fast = k-1;
        int[] max = new int[nums.length-k+1];
        while (slow < nums.length-k+1) {
            int m = Integer.MIN_VALUE;
            for (int i = slow; i <= fast; i++) {
                if (nums[i] > m){
                    m = nums[i];
                }
            }
            max[slow] = m;
            slow++;
            fast++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] i = new int[]{1,3,-1,-3,5,3,6,7};
        int[] re = maxSlidingWindow(i, 3);
        for (int j = 0; j < re.length; j++) {
            System.out.println(re[j]);
        }
    }
}
