class Solution {
    private boolean check(String a, String b) {
        if(a.length() != b.length() + 1) return false;
        int first = 0;
        int second = 0;
        while(first < a.length()) {
            if(second < b.length() && a.charAt(first) == b.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        if(first == a.length() && second == b.length()) return true;
        return false;
    }
    public int longestStrChain(String[] arr) {
      int n = arr.length;
      int[] dp = new int[n];
      Arrays.sort(arr, (a, b) -> a.length() - b.length());
      Arrays.fill(dp, 1);
      int maxi = 1;
      for(int i = 0; i < n; i++) {
         for(int prev = 0; prev < i; prev++) {
            if(check(arr[i], arr[prev]) && 1 + dp[prev] > dp[i]) {
                dp[i] = dp[prev] + 1;
            }
            if(dp[i] > maxi) {
                maxi = dp[i];
            }
         }
      }
     return maxi;
    }
}