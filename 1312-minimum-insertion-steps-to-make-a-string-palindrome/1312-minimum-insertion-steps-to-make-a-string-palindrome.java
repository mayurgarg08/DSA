class Solution {
    private int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int j = 0; j <= m; j++) dp[0][j] = 0;
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int idx1 = 1; idx1 <= n; idx1++) {
            for(int idx2 = 1; idx2 <= m; idx2++) {
                if(s.charAt(idx1-1) == t.charAt(idx2-1)) dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                else dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
            }
        }
        return dp[n][m];
    }
    private String reverse(String s) {
        StringBuilder rev = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }
    private int lps(String s) {
        String t = reverse(s);
        return lcs(s, t);
    }
    public int minInsertions(String s) {
        int n = s.length();
        return n - lps(s);
    }
}