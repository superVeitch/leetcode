package com.leetcode.algorithms.rangeSumBST;

import java.util.Objects;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 *
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 *
 *
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质
 * 的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所
 * 有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 */
public class RangeSumBST {
    public static int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (Objects.isNull(root)){
            return sum;
        }
        if (root.val < L){
            return rangeSumBST(root.right, L, R);
        }

        if (root.val > R){
            return rangeSumBST(root.left, L, R);
        }

        if (root.val >= L && root.val <= R){
            return sum + root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
        return sum;
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right = new TreeNode(15);
        treeNode.right.right = new TreeNode(18);
        int sum = rangeSumBST(treeNode, 7, 15);
        System.out.println(sum);
    }
}
