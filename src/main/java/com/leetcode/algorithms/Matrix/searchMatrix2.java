package com.leetcode.algorithms.Matrix;


/**
 * 二维数组中元素的排列规则为
 *
 * 每一行的元素从左到右按递增顺序排列
 * 每一列的元素从上到下按递增顺序排列
 */
public class searchMatrix2 {

  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0)
      return false;
    int m = matrix.length;
    int n = matrix[0].length;
    int i = 0, j = n - 1;
    while(i < m && j >= 0)
    {
      if(matrix[i][j] == target)
        return true;
        /* 向左移动 */
      else if(matrix[i][j] > target)
        --j;
        /* 向下移动 */
      else
        ++i;
    }
    return false;
  }
}
