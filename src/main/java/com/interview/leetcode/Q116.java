package com.interview.leetcode;

import com.interview.leetcode.utils.BTPrinter;
import com.interview.leetcode.utils.TreeNode;

/**
 * 节点的 next 指向树结构的右侧节点，如果没有填充值设置为 null
 */
public class Q116 {
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n4, n5);

        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3, n6, n7);

        TreeNode n1 = new TreeNode(1, n2, n3);

        new Q116().connect(n1);

        BTPrinter.preorderTraversalNext(n1);
    }

    public TreeNode connect(TreeNode root) {
        if (root == null || root.left == null)
            return null;

        connectTwoNode(root.left, root.right);

        return root;
    }

    private void connectTwoNode(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null)
            return;

        // 前序中的当前节点操作
        n1.next = n2;

        // 当前节点的左右节点链接
        connectTwoNode(n1.left, n1.right);
        connectTwoNode(n2.left, n2.right);

        // 跨界点之间的链接
        connectTwoNode(n1.right, n2.left);
    }
}
