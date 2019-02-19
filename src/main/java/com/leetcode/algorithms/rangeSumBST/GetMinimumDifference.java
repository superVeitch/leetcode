package com.leetcode.algorithms.rangeSumBST;

import java.util.Objects;

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * 输入:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出:
 * 1
 *
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class GetMinimumDifference {

    private static int result = Integer.MAX_VALUE;
    private static TreeNode preNode = null;
    public int getMinimumDifference1(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (Objects.isNull(root)){
            return min;
        }
        return Math.min(Math.min(Math.min(min, Math.abs(root.val)), getMinimumDifference1(root.left)),
                getMinimumDifference1(root.right));
    }

    public static int getMinimumDifference(TreeNode root) {
        //二叉查找树中，中间节点的值一定是其左右节点值的中间数，因此最小差别一定是在中间节点与左右节点之间
        //中序遍历二叉查找树，每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，将较小的保存在result中
        getMin(root);
        return result;
    }

    private static void getMin(TreeNode root){

        if(root == null){
            return;
        }

        getMin(root.left);

        if(preNode != null)
        {
            result = Math.min(Math.abs(root.val - preNode.val), result);
        }
        preNode = root;

        getMin(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(3);
        System.out.println(getMinimumDifference(treeNode));
    }

}
