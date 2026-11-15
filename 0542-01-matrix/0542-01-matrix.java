class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int n = mat.length;
       int m = mat[0].length;
       int[][] ans = new int[n][m];
       int[][] vis = new int[n][m];
       int dist = 0;
       Queue<int[]> q = new LinkedList<>();
       for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(mat[i][j] == 0) {
                 q.offer(new int[]{i, j});
                 vis[i][j] = 1;
            }
        }
       }

       int[] dr = {-1, 0, 1, 0};
       int[] dc = {0, 1, 0, -1};

       while(!q.isEmpty()) {
          int size = q.size();
          for(int i = 0; i < size; i++) {
              int[] curr = q.poll();
              int row = curr[0];
              int col = curr[1];
              for(int k = 0; k < 4; k++) {
                int drow = dr[k] + row;
                int dcol = dc[k] + col;

                if(drow >= 0 && drow < n && dcol < m && dcol >= 0 && vis[drow][dcol] == 0) {
                    ans[drow][dcol] = dist+1;
                    vis[drow][dcol] = 1;
                    q.offer(new int[]{drow, dcol});
                }
              }
          }
          dist++;
       }
       return ans;
    }
}