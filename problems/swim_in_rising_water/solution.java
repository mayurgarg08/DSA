class Solution {
    public int swimInWater(int[][] grid) {
          PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

          int n = grid.length;
          int[][] vis = new int[n][n];
          vis[0][0] = 1;
          pq.add(new int[] {grid[0][0], 0, 0});
                      
            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, 1, 0, -1};

          while(pq.size() != 0) {
            int[] curr = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(row == n-1 && col == n-1) return time;

            for(int i = 0; i< 4; i++) {
                int nrow = drow[i]+row;
                int ncol = dcol[i]+col;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0) {
                     vis[nrow][ncol] = 1;
                     int maxTime = Math.max(time, grid[nrow][ncol]);
                     pq.add(new int[] {maxTime, nrow, ncol});
                }
            }
          }
          return -1;
    }
}