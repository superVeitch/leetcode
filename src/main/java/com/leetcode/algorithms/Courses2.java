package com.leetcode.algorithms;


import java.util.Arrays;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example
 *
 * Example 1:
 *
 * Input: n = 2, prerequisites = [[1,0]]
 *
 * Output: [0,1]
 *
 * Example 2:
 *
 * Input: n = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 *
 * Output: [0,1,2,3] or [0,2,1,3]
 */
public class Courses2 {

  /**
   * 假设元素不会重复，
   * @param n
   * @param prerequisites
   * @return
   */
  public List<Integer> courses(int n, List<List<Integer>> prerequisites){
    return null;
  }

  public static void main(String[] args) {
    List<String> a = Arrays.asList("12", "34");
    System.out.println(a);
  }

}
