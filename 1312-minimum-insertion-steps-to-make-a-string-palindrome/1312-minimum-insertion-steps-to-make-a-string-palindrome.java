class Solution {
    private int helper(int idx1, int idx2, String s, String t, int[][] dp) {
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(s.charAt(idx1) == t.charAt(idx2)) return dp[idx1][idx2] = 1 + helper(idx1 - 1, idx2 - 1, s, t, dp);
        return dp[idx1][idx2] = Math.max(helper(idx1-1, idx2, s, t, dp), helper(idx1, idx2-1, s, t, dp));
    }
    private int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(n-1, m-1, s, t, dp);
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