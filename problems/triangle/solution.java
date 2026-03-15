class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];

        return dfs(triangle, 0, 0, dp);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j, Integer[][] dp) {

        if(i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        int down = dfs(triangle, i + 1, j, dp);
        int diagonal = dfs(triangle, i + 1, j + 1, dp);

        dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);

        return dp[i][j];
    }
}