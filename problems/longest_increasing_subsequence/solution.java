class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int idx = n-1; idx >= 0; idx--) {
            for(int prev = idx-1; prev >= -1; prev--) {
                int len = 0 + dp[idx+1][prev+1];
                if(prev == -1 || nums[idx] > nums[prev]) {
                   len = Math.max(len, 1 + dp[idx+1][idx+1]);
                }
                dp[idx][prev+1] = len;
            }
        }
        return dp[0][0];
    }
    // private int helper(int idx, int prev, int[][] dp, int[] nums) {
    //     if(idx == nums.length) {
    //         return 0;
    //     }
    //     if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
    //     int len = 0 + helper(idx+1, prev, dp, nums);
    //     if(prev == -1 || nums[idx] > nums[prev]) {
    //         len = Math.max(len, 1 + helper(idx+1, idx, dp, nums));
    //     }
    //     return dp[idx][prev+1] = len;
    // }
}