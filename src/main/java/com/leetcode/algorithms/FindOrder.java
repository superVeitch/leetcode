package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * Input: n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 *
 * Output: [0,1,2,3] or [0,2,1,3]
 *
 *
 * 思路：这个题目是一个典型的拓扑排序的应用。首先我们需要从输入参数`prerequisites`构建有向图的边，
 * 并且记录每个节点的入度，节点的入度即为其先决课程的数量，如果入度为0，我们就可以学习该课程。有向图建立后，借助队列采用BFS遍历。
 */
public class FindOrder {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // write your code here
    int[] inDegree = new int[numCourses];
    List<List<Integer>> edges = new ArrayList<>();
    // 用于存储拓扑排序的结果
    int[] res = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      edges.add(new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
      // 记录所有边的入度（统计先决条件）
      inDegree[pre[0]]++;
      // 存储以此节点为起点的有向边
      edges.get(pre[1]).add(pre[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      res[count++] = cur;
      List<Integer> edge = edges.get(cur);
      for (int no : edge) {
        // 先决条件的数量递减
        inDegree[no]--;
        if (inDegree[no] == 0) {
          queue.offer(no);
        }
      }
    }
    return count == numCourses ? res : new int[]{};
  }

  /**
   * 入参为[0~(n-1)]
   */
  class Solution {
    int[] visited;
    List[] edges;
    List<Integer> sortedList;

    // 课程的数量
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      if (numCourses == 0) {
        return new int[numCourses];
      }
      if (prerequisites == null || prerequisites.length == 0
        || prerequisites[0] == null || prerequisites[0].length == 0) {
        int[] rst = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
          rst[i] = i;
        }
        return rst;
      }

      sortedList = new ArrayList<>();
      edges = new ArrayList[numCourses];
      visited = new int[numCourses];

      // Initialize
      for (int i = 0; i < numCourses; i++) {
        edges[i] = new ArrayList<Integer>();
      }

      // Build graph edges
      for (int[] prerequisite : prerequisites) {
        edges[prerequisite[1]].add(prerequisite[0]);
      }

      // DFS serach && marking visited
      for (int i = 0; i < numCourses; i++) {
        if(!dfs(i)) {
          return new int[]{ };
        }
      }

      int[] rst = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
        rst[i] = sortedList.get(i);
      }

      return rst;
    }

    // 深度优先搜索
    public boolean dfs(int node) {
      if (visited[node] == 1) {
        return true;
      }
      if (visited[node] == -1) { // cyclic
        return false;
      }
      // 设置当前节点值为-1，深度搜索子节点也为-1则认为有环
      visited[node] = -1;
      List<Integer> childNodes = edges[node];
      for (Integer childNode : childNodes) {
        if (!dfs(childNode)) {
          return false;
        }
      }
      visited[node] = 1;
      // 此处为递归深度优先搜索，所以最先添加的是深度最大的值
      sortedList.add(0, node);

      return true;
    }
  }

}
