class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int fresh = 0;
        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            boolean flag = false;
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
         
                for(int k = 0; k < 4; k++) {
                    int drow = row + dr[k];
                    int dcol = col + dc[k];

                    if(drow >= 0 && drow < n && dcol < m && dcol >= 0 && vis[drow][dcol] == 0 && grid[drow][dcol] == 1) {
                        q.offer(new int[]{drow, dcol});
                        vis[drow][dcol] = 1;
                        fresh--;
                        flag = true;
                    }
                }
            }
            if(flag) count++;
        }
        return fresh == 0 ? count : -1;
    }
}