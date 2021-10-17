package com.interview.other;

import java.util.Arrays;

public class Qsort {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 54, 3, 35, 19, 12};
        System.out.println("Before: " + Arrays.toString(nums));
        qsort(nums, 0, nums.length - 1);
        System.out.println("After : " + Arrays.toString(nums));
    }

    private static void qsort(int[] nums, int start, int end) {
        // 如果待排序长度小于1，返回
        if (end - start <= 1) return;

        // 根据 pivot 排序并返回 pivot 地址
        int pos = partition(nums, start, end);
        qsort(nums, start, pos - 1);
        qsort(nums, pos + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (end > start) {
            while (nums[end] >= pivot && end > start)
                end--;
            nums[start] = nums[end];
            while (nums[start] < pivot && end > start)
                start++;
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }
}
