class Solution {
    private void dfs(int sr, int sc, int[][] vis, int[][] image, int color, int[][] ans, int n, int m) {
        vis[sr][sc] = 1;
        ans[sr][sc] = color;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++) {
            int drow = sr + dr[i];
            int dcol = sc + dc[i];

            if(drow >= 0 && drow < n && dcol >= 0 && dcol < m && image[drow][dcol] == image[sr][sc] && vis[drow][dcol] == 0) {
                dfs(drow, dcol, vis, image, color, ans, n, m);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int n = image.length;
       int m  = image[0].length;
       int[][] vis = new int[n][m];
       int[][] ans = new int[n][m];
       for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            ans[i][j] = image[i][j];
        }
       }
       dfs(sr, sc, vis, image, color, ans, n, m);
       return ans;
    }
}