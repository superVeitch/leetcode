package com.leetcode.algorithms;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] re = new int[digits.length];
        int[] re1 = new int[digits.length + 1];
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == 0 && digits[0] == 9 && add == 1) {
                re1[0] = 1;
                return re1;
            } else {
                if (add == 1) {
                    if (digits[i] == 9) {
                        re[i] = 0;
                    } else {
                        add = 0;
                        re[i] = digits[i] + 1;
                    }
                } else {
                    re[i] = digits[i];
                }
            }
        }
        return re;
    }

}
