class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        prev[0] = 1;   

        for(int i = 1; i<= n; i++) {
            int[] curr = new int[m+1];
            curr[0] = 1;
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                  curr[j] =  prev[j-1] + prev[j];
                }
                else curr[j] = prev[j];
            }
            prev = curr;
        }
        return prev[m];
    }
    // private int helper(int i, int j, int[][] dp, String s, String t) {
    //     if(j < 0) return 1;
    //     if(i < 0) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     if(s.charAt(i) == t.charAt(j)) {
    //         return helper(i-1, j-1, dp, s, t) + helper(i-1, j, dp, s, t);
    //     }
    //     return dp[i][j] = helper(i-1, j, dp, s, t);
    // }
}