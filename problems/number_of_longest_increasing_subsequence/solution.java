class Solution {
    public int findNumberOfLIS(int[] arr) {
      int n = arr.length;
      int[] dp = new int[n];
      int[] cnt = new int[n];
      Arrays.fill(dp, 1);
      Arrays.fill(cnt, 1);
      int maxi = 0;
      for(int i = 0; i < n; i++) {
         for(int prev = 0; prev < i; prev++) {
            if(arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
                dp[i] = dp[prev] + 1;
                cnt[i] = cnt[prev];
            } else if(arr[prev] < arr[i] && 1 + dp[prev] == dp[i]) {
                cnt[i] += cnt[prev];
            }
         }
         maxi = Math.max(maxi, dp[i]);
      }
      int ans = 0;
      for(int i = 0; i < n; i++) {
        if(dp[i] == maxi) ans += cnt[i];
      }
      return ans;
    }
}