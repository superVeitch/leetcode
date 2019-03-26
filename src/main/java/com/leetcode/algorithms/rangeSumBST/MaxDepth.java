package com.leetcode.algorithms.rangeSumBST;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {

    /**
     * 递归求每个节点的深度，然后求和
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (Objects.isNull(root)){
            return depth;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 使用queue辅助遍历
     * @param root
     * @return
     */
    public int maxDepthForEach(TreeNode root) {
        int depth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (!Objects.isNull(root)){
            queue.offer(new Pair(root, 1));
        }

        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> currPair = queue.poll();
            TreeNode node = currPair.getKey();
            int de = currPair.getValue();
            if (!Objects.isNull(node)){
                depth = Math.max(depth, de);
                queue.offer(new Pair(node.left, ++de));
                queue.offer(new Pair(node.right, ++de));
            }
        }
        return depth;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 开始遍历该层时，作为倒记数进行遍历
        int preCount = 1;
        // 统计每层节点的个数
        int pCount = 0;
        // 记录最大深度
        int level = 0;

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            preCount--;

            if (temp.left != null) {
                q.offer(temp.left);
                pCount++;
            }
            if (temp.right != null) {
                q.offer(temp.right);
                pCount++;
            }

            if (preCount == 0) {
                preCount = pCount;
                pCount = 0;
                // System.out.println();
                level++;
            }
        }
        return level;
    }
}
