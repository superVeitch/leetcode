package com.leetcode.algorithms;

import java.util.Objects;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 */
public class StrStr {

    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle, 0);
    }
}
