package com.interview.leetcode.utils;

public class BTPrinter {
    public static void preorderTraversal(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void preorderTraversalNext(TreeNode root) {
        if (root == null)
            return;

        System.out.println("Node [" + root.val + "]'s next node: [" + (root.next == null? "null" : root.next) + "]");
        preorderTraversalNext(root.left);
        preorderTraversalNext(root.right);
    }
}
