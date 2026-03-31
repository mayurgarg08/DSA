class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] prev = new boolean[n+1];
    
    prev[0] = true;

    for(int j = 1; j <= n; j++) {
        if(p.charAt(j-1) == '*') {
            prev[j] = prev[j-1];
        }
    }

    for(int i = 1; i <= m; i++) {
        boolean[] curr = new boolean[n+1];
        curr[0] = false; 

        for(int j = 1; j <= n; j++) {

            if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
                curr[j] = prev[j-1];
            }

            else if(p.charAt(j-1) == '*') {
                curr[j] = prev[j] || curr[j-1];
            }

            else {
                curr[j] = false;
            }
        }

        prev = curr;
    }

    return prev[n];
}
    // private boolean helper(int i, int j, boolean[][] dp, String p, String s) {

    //     if(i < 0 && j < 0) return true;

    //     if(i < 0 && j >= 0) return false;

    //     if(i >= 0 && j < 0) {
    //         for(int k = 0; k <= i; k++) {
    //             if(p.charAt(k) != '*') return false;
    //         }
    //         return true;
    //     }

    //     if(dp[i][j] != null) return dp[i][j];

    //     if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
    //         return dp[i][j] = helper(i-1, j-1, dp, p, s);
    //     }

    //     if(p.charAt(i) == '*') {
    //         return dp[i][j] = helper(i-1, j, dp, p, s) 
    //                       || helper(i, j-1, dp, p, s);
    //     }

    //     return dp[i][j] = false;
    // }
}