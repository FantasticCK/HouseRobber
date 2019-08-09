package com.CK;

public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
                continue;
            }
            if (i == 1) {
                dp[i] = Math.max(nums[i], nums[i - 1]);
                continue;
            }
            dp[i % 3] = Math.max(dp[(i - 1) % 3], dp[(i - 2) % 3] + nums[i]);
        }
        return dp[(nums.length - 1) % 3];
    }
}