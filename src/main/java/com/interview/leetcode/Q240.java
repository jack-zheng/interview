package com.interview.leetcode;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class Q240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(new Q240().findNumberIn2DArray(matrix, 5));
        System.out.println(new Q240().findNumberIn2DArray(matrix, 20));
    }

    /**
     * 从右上角开始判断，
     * 如果等于目标值，返回下标
     * 如果大于目标值，删除列
     * 如果小于目标值，删除行
     *
     * 时间复杂度：O(n+m)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int high = matrix.length, width = matrix[0].length;
        int row = 0, column = width - 1;
        while (row < high && column >= 0) {
            int num = matrix[row][column];
            if (num == target)
                return true;
            else if (num > target)
                column--;
            else if (num < target)
                row++;
        }
        return false;
    }

    /**
     * 题解中还有一种很 geek 的方式，将整个二维数组转化为 tree 进行搜索，有点吊，等我复习完树相关内容再回来看
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray_tree(int[][] matrix, int target) {

        return false;
    }
}
