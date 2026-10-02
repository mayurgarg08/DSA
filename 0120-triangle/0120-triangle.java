class Solution {
    private int helper(int i, int j, int n, int[][] dp, List<List<Integer>> triangle) {
        if(i == n-1) return triangle.get(n-1).get(j);
        if(j >= triangle.get(i).size()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int left = helper(i+1, j, n, dp, triangle);
        int right = helper(i+1, j+1, n, dp, triangle);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
       int[] prev = new int[n];
       for(int j = 0; j < n; j++) {
         prev[j] = triangle.get(n - 1).get(j);
       }
       for(int i = n-2; i >= 0; i--) {
        int[] curr = new int[n];
          for(int j = 0; j < triangle.get(i).size(); j++) {
                int left = prev[j];
                int right = prev[j+1];
                 curr[j] = triangle.get(i).get(j) + Math.min(left, right);   
          }
          prev = curr;
       }
       return prev[0];
    }
}