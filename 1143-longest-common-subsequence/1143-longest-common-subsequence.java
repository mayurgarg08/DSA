class Solution {
    private int helper(int i, int j, String s, String t, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = 1 + helper(i-1, j-1, s, t, dp);
        return dp[i][j] = Math.max(helper(i-1, j, s, t, dp), helper(i, j-1, s, t, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(n-1, m-1, text1, text2, dp);    
    }
}