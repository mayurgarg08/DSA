class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
       int[] next = new int[n];
       for(int j = 0; j < triangle.get(n-1).size(); j++) next[j] = triangle.get(n-1).get(j);
       for(int row = n-2; row >= 0; row--) {
          int[] curr = new int[n];
           for(int col = row; col >= 0; col--) {
                int d = triangle.get(row).get(col) + next[col];
                int dg = triangle.get(row).get(col) + next[col+1];
                curr[col] = Math.min(d, dg);
           }
           next = curr;
       }
       return next[0];
    }
    // private int helper(int row, int col, int[][] dp, List<List<Integer>> triangle) {
    //     if(row == triangle.size()-1) return triangle.get(row).get(col);
    //     if(dp[row][col] != -1) return dp[row][col];
    //      int d = triangle.get(row).get(col) + helper(row+1, col, dp, triangle);
    //      int dg = triangle.get(row).get(col) + helper(row+1, col+1, dp, triangle);
    //      return dp[row][col] = Math.min(d, dg);
    // }
}