class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        for(int idx1 = 1; idx1 <= n; idx1++) {
            int[] curr = new int[m+1];
            for(int idx2 = 1; idx2 <= m; idx2++) {
                
                 if(text1.charAt(idx1-1) == text2.charAt(idx2-1)) {
                     curr[idx2] = 1 + prev[idx2-1];
                 }
                 else curr[idx2] = Math.max(0 + prev[idx2], 0 + curr[idx2-1]);
            }
            prev = curr;
        }
        return prev[m];
    }
    // private int helper(int idx1, int idx2, int[][] dp, String text1, String text2) {
    //     if(idx1 < 0 || idx2 < 0) {
    //         return 0;
    //     }
    //     if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
    //     if(text1.charAt(idx1) == text2.charAt(idx2)) {
    //         return 1 + helper(idx1-1, idx2-1, dp, text1, text2);
    //     }
    //      return dp[idx1][idx2] = Math.max(0 + helper(idx1-1, idx2, dp, text1, text2), 0 + helper(idx1, idx2-1, dp, text1, text2));
    // }
}