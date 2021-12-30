package com.interview.leetcode;

import com.interview.leetcode.utils.BTPrinter;
import com.interview.leetcode.utils.TreeNode;

/**
 * 二叉树展开为链表
 *
 *      1
 *    /   \
 *   2     5
 *  / \     \
 * 3   4     6
 *
 * 展开为
 *1
 * \
 *  2
 *   \
 *    3
 *     \
 *      4
 *       \
 *        5
 *         \
 *          6
 *
 * 观察每个节点的任务，其实是将子节点的左右节点交换位置，之后将左节点续接到右节点上就行了。
 */
public class Q114 {

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n3, n4);

        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5, null, n6);

        TreeNode n1 = new TreeNode(1, n2, n5);

        BTPrinter.preorderTraversal(n1);

        System.out.println("After flatten: ");
        flatten(n1);

        TreeNode tmp = n1;
        while(tmp != null) {
            System.out.print(tmp.val + " -> ");
            tmp = tmp.right;
        }
    }

    private static void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        // 采用后序遍历，此时节点已经拉直了
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 交换
        root.left = null;
        root.right = left;

        // 续接, 拿到右节点的最有一个 node, 将做节点接续上
        TreeNode last = root;
        while(last.right != null){
            last = last.right;
        }
        last.right = right;
    }
}
