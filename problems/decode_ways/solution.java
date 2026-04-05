class Solution {
    // private int helper(int idx, int n, String s, int[] dp) {
    //     if(idx == n) return 1;
    //     if(dp[idx] != -1) return dp[idx];
    //     if(s.charAt(idx) - '0' == 0) return 0;
        
    //     int ways = helper(idx+1, n, s, dp);
    //     if(idx+1 < n) {
    //         int num = (s.charAt(idx) - '0')*10 + (s.charAt(idx+1)-'0');
    //         if(num >= 10 && num <= 26) {
    //             ways += helper(idx+2, n, s, dp);
    //         }
    //     }
    //     return dp[idx] = ways;
    // }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
       dp[n] = 1;
       for(int idx = n-1; idx >= 0; idx--) {
          if(s.charAt(idx) - '0' == 0) {
            dp[idx] = 0;
            continue;
          }  
        int ways = dp[idx+1];
        if(idx+1 < n) {
            int num = (s.charAt(idx) - '0')*10 + (s.charAt(idx+1)-'0');
            if(num >= 10 && num <= 26) {
                ways += dp[idx+2];
            }
        }
        dp[idx] = ways;
       }
       return dp[0];
    }
}