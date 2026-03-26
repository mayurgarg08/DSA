class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        for(int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) curr[j] = 1;
                else {
                    int left = 0, up = 0;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = curr[j-1];
                    curr[j] = left + up; 
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
    // private int helper(int m, int[][] dp, int n) {
    //     if(m == 0 && n == 0) return 1;
    //     if(m < 0 || n < 0) return 0;
    //     if(dp[m][n] != -1) return dp[m][n];
    //     int left = helper(m, dp, n-1);
    //     int up = helper(m-1, dp, n);
    //     return dp[m][n] = left + up;
    // }
}