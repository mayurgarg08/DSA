class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int n = mat.length;
       int m = mat[0].length;
       int[][] vis = new int[n][m];
       int[][] ans = new int[n][m];
       Queue<int[]> q = new LinkedList<>();
       int count = 0;
       for(int i = 0; i < n; i++) {
           for(int j = 0; j < m; j++) {
              if(mat[i][j] == 0) {
                q.offer(new int[]{i, j});
                vis[i][j] = 1;
              }
           }
       }

       int[] di = {-1, 0, 1, 0};
       int[] dj = {0, 1, 0, -1};

       int dist = 0; 

       while(!q.isEmpty()) {
        int size = q.size();
        for(int i = 0; i < size; i++) {
           
           int[] curr = q.poll();
           int row = curr[0];
           int col = curr[1];
           for(int k = 0; k < 4; k++) {
               int drow = di[k] + row;
               int dcol = dj[k] + col;

               if(drow >= 0 && drow < n && dcol >= 0 && dcol < m && vis[drow][dcol] == 0) {
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