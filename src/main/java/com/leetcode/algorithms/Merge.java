package com.leetcode.algorithms;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        int init = 0;
        for (int i = 0; i < n; i++) {
            for (int j = init; j < nums1.length; j++) {
                if (j >= m+i) {
                    if (nums1[j] == 0) {
                        nums1[j] = nums2[i];
                        break;
                    }
                }
                if (nums2[i] == nums1[j]) {
                    continue;
                }
                if (nums2[i] < nums1[j]) {
                    init = i+1;
                    int tem = nums2[i];
                    nums2[i] = nums1[j];
                    nums1[j] =tem;
                }
            }
        }
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}
