package com.interview.leetcode;

import com.interview.leetcode.utils.BTPrinter;
import com.interview.leetcode.utils.TreeNode;

/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 * 翻转二叉树
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 观察树结构可以知道，本质上来讲，要做的事情是遍历节点并将左右子节点交换位置即可
 */
public class Q226 {
    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);

        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n7 = new TreeNode(7, n6, n9);

        TreeNode root = new TreeNode(4, n2, n7);

        BTPrinter.preorderTraversal(root);

        invertTree(root);
        System.out.println("\nAfter transfer: ");

        BTPrinter.preorderTraversal(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        // 处理当前节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 前序遍历，对子节点做相同的操作
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
