class Solution {
    private int helper(int i, int n, int k, int[] arr, int[] dp) {
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int j = i; j < Math.min(n, i+k); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (len*maxi) + helper(j+1, n, k, arr, dp);
            maxSum = Math.max(sum, maxSum);
        }
        return dp[i] = maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
          int n = arr.length;
          int[] dp = new int[n+1];
          dp[n] = 0;
           
          for(int i = n-1; i >= 0; i--) {
            int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int j = i; j < Math.min(n, i+k); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (len*maxi) + dp[j+1];
            maxSum = Math.max(sum, maxSum);
        }
         dp[i] = maxSum;
          }
          return dp[0]; 
    }
}