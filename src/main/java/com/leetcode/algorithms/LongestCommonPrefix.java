package com.leetcode.algorithms;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0){
      return "";
    }
    String s = strs[0];
    char[] chars = new char[s.length()];
    for (int i = 0, l = s.length(); i < l; i++) {
      char c = s.charAt(i);
      for (int j = 1, l1 = strs.length; j < l1; j++) {
        if (strs[j].length()-1 < i || c != strs[j].charAt(i)) {
          return String.valueOf(chars).trim();
        }
      }
      chars[i] = c;
    }
    return String.valueOf(chars).trim();
  }
}
