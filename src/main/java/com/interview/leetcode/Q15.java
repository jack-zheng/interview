package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class Q15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new Q15().threeSum(nums));

        // 输出：[[-1, -1, 2],[-1, 0, 1]]
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums == null || nums.length < 3) return ret;

        Arrays.sort(nums);
        int len = nums.length;

        for (int first = 0; first < len; first++) {
            if (nums[first] > 0) return ret;
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int second = first + 1, third = len - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == 0) {
                    ret.add(Arrays.asList(nums[first], nums[second], nums[third])); // add to ret
                    while (second < third && nums[second] == nums[second + 1]) second++; // skip same value
                    while (second < third && nums[third]  == nums[third - 1])  third--;  // skip same value
                    second++;
                    third--;
                }
                else if (sum < 0) second++; // increase second index
                else third--;               // decrease third index
            }
        }
        return ret;
    }
}
