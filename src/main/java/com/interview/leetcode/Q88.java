package com.interview.leetcode;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class Q88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        // new Q88().merge1(nums1, m, nums2, n);
        // new Q88().merge2(nums1, m, nums2, n);
        new Q88().merge3(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 暴力解
     * 通过 Java 内置函数将 nums2 copy 到 nums1 中再通过自带的 sort 函数排序即可
     * 时间：O((m+n)log^(m+n))
     * 空间：O(log(m+n))
     * 和快速排序一致
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针
     * copy 一个 nums1 的副本，然后从头到尾分别比较 nums1_copy 和 nums2 两个数组的大小并插入到 num1 中
     * 时间：O(m+n)
     * 空间：O(m+n)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = Arrays.copyOf(nums1, nums1.length);

        int copyIndex = 0;
        int nums2Index = 0;
        for (int i = 0; i < nums1.length; i++) {
            int cur;
            if (copyIndex == m) {
                cur = nums2[nums2Index++];
            } else if (nums2Index == n) {
                cur = copy[copyIndex++];
            } else if (copy[copyIndex] < nums2[nums2Index]) {
                cur = copy[copyIndex++];
            } else {
                cur = nums2[nums2Index++];
            }
            nums1[i] = cur;
        }
    }

    /**
     * 双指针
     * 思路和 2 相同，但采用从后向前的方式插入，节省了 copy 的空间
     * 时间：O(m+n)
     * 空间：O(m+n)
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            int cur;
            if (p1 < 0) {
                cur = nums2[p2--];
            } else if (p2 < 0) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[i] = cur;
        }
    }
}
