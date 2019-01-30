package com.leetcode.algorithms.binarySearchTree;

public class MinDiffInBST {

    private static int result = Integer.MAX_VALUE;
    private static TreeNode preNode;
    public static int minDiffInBST(TreeNode root) {
        getMin(root);
        return result;
    }
    private static void getMin(TreeNode root){
        if(root == null){
            return;
        }
        getMin(root.left);
        if(preNode != null){
            result = Math.min(root.val - preNode.val, result);
        }
        preNode = root;
        getMin(root.right);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(2);
        t.right = new TreeNode(6);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(3);
        minDiffInBST(t);
    }
}
