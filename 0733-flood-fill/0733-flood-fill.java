class Solution {
    private void dfs(int[][] image, int n, int m, int[][] ans, int sr, int sc, int[][] vis, int color) {
        vis[sr][sc] = 1;
        ans[sr][sc] = color;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int i = 0; i < 4; i++) {
            int drow = sr + dr[i];
            int dcol = sc + dc[i];

            if(drow >= 0 && drow < n && dcol < m && dcol >= 0 && vis[drow][dcol] == 0 && image[drow][dcol] == image[sr][sc]) {
                dfs(image, n, m, ans, drow, dcol, vis, color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int n = image.length;
       int m = image[0].length;
       int[][] ans = new int[n][m];
       int[][] vis = new int[n][m];
       for(int i = 0; i < n; i++) {
         for(int j = 0; j < m; j++) {
             ans[i][j] = image[i][j];
         }
       }
       dfs(image, n, m, ans, sr, sc, vis, color);
       return ans;
    }
}