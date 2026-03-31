class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int idx1 = 1; idx1 <= n; idx1++) {
            for(int idx2 = 1; idx2 <= m; idx2++) {
                
                 if(text1.charAt(idx1-1) == text2.charAt(idx2-1)) {
                     dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                 }
                 else dp[idx1][idx2] = Math.max(0 + dp[idx1-1][idx2], 0 + dp[idx1][idx2-1]);
            }
        }
       StringBuilder ans = new StringBuilder();
       int i = n, j = m;
       while(i > 0 && j > 0) {
          if(text1.charAt(i-1) == text2.charAt(j-1)) {
            ans.append(text1.charAt(i-1));
            i--;
            j--;
          }
          else if(dp[i-1][j] > dp[i][j-1]) {
            ans.append(text1.charAt(i-1));
            i--;
          } else {
            ans.append(text2.charAt(j-1)); 
            j--;
          }
       }
       while(i > 0) {
        ans.append(text1.charAt(i-1));
        i--;
       }
       while(j > 0) {
        ans.append(text2.charAt(j-1));
        j--;
       }
       return ans.reverse().toString();
    }
}