class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m+1];
         
        for(int j = 0; j <= m; j++) prev[j] = j;

        for(int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            curr[0] = i;
            for(int j = 1; j <= m; j++) {
                  if(word1.charAt(i-1) == word2.charAt(j-1)) {
                      curr[j] = prev[j-1];
                  }
                  else curr[j] = Math.min(1 + prev[j], Math.min(1 + curr[j-1], 1 + prev[j-1]));           
            }
            prev = curr;
        }
        return prev[m];
    }
    // private int helper(int i, int j, int[][] dp, String s, String t) {
    //     if(i < 0) return j+1;
    //     if(j < 0) return i+1;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     if(s.charAt(i) == t.charAt(j)) {
    //         return helper(i-1, j-1, dp, s, t);
    //     }
    //     return dp[i][j] = Math.min(1 + helper(i-1, j, dp, s, t), Math.min(1 + helper(i, j-1,  dp, s, t), 1 + helper(i-1, j-1, dp, s, t)));
    // }
}