class Solution {
    // private int helper(int idx, int prev, int n, int[][] dp, int[] nums) {
    //     if(idx == n) return 0;
    //     if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
    //     int len = 0 + helper(idx+1, prev, n, dp, nums);
    //     if(prev == -1 || nums[idx] > nums[prev]) {
    //         len = Math.max(len, 1 + helper(idx+1, idx, n, dp, nums));
    //     }
    //     return dp[idx][prev+1] = len;
    // }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        for(int idx = n-1; idx >= 0; idx--) {
            int[] curr = new int[n+1];
            for(int prev = idx-1; prev >= -1; prev--) {
                int len = 0 + next[prev+1];
                if(prev == -1 || nums[idx] > nums[prev]) {
                   len = Math.max(len, 1 + next[idx+1]);
                }
                curr[prev+1] = len;
            }
            next = curr;
        }
        return next[0];
    }
}