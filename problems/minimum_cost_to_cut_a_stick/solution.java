class Solution {
    public int minCost(int n, int[] cuts) {
        int c= cuts.length;
        int[] arr = new int[c+2];
        Arrays.sort(cuts);
        arr[0] = 0;
        for(int i = 1; i <= c; i++) {
            arr[i] = cuts[i-1];
        }
        arr[c+1] = n;
        int[][] dp = new int[c+2][c+2];
        
        for(int i = c; i >= 1; i--) {
            for(int j = 1; j <= c; j++) {
            if(i > j) continue;
            int mini = Integer.MAX_VALUE;

           for(int idx = i; idx <= j; idx++) {
              int cost = arr[j+1] - arr[i-1] + dp[i][idx-1] + dp[idx+1][j];
              if(cost < mini) mini = cost;
        }
              dp[i][j] = mini;       
            }
        }
        return dp[1][c];
    }
}