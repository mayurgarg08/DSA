
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        int count = 0;
        int fresh = 0;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = 1;
                }
                if(grid[i][j] == 1) fresh++;
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for(int i = 0; i < size; i++) {
                 int[] curr = q.poll();
                 int row = curr[0];
                 int col = curr[1];
                 
                 for(int k = 0; k < 4; k++) {
                    int drow = di[k] + row;
                    int dcol = dj[k] + col;

                    if(drow >= 0 && drow < n && dcol >= 0 && dcol < m && vis[drow][dcol] == 0 && grid[drow][dcol] == 1) {
                        q.offer(new int[]{drow, dcol});
                        vis[drow][dcol] = 1;
                        fresh--;
                        flag = true;
                    }
                }
            }
            if(flag == true) count += 1; 
        }
        return fresh == 0 ? count: -1;
    }
}