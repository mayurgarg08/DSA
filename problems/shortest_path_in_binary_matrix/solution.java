class tuple {
    int first;
    int second;
    int third;
    tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        if(n == 1 && m == 1) return 1;
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(1, 0, 0));
        int[][] dist = new int[n][m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;
        int[] drow = {-1, -1, -1,  0,  0,  1,  1,  1};
        int[] dcol = {-1,  0,  1, -1,  1, -1,  0,  1};
        while(!q.isEmpty()) {
           tuple it  = q.poll();
           int dis = it.first;
           int row = it.second;
           int col = it.third;

           for(int i = 0; i < 8; i++) {
              int nrow = row+drow[i];
              int ncol = col + dcol[i];

               if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && dis + 1 < dist[nrow][ncol]) {
             dist[nrow][ncol] = dis + 1;
             if(nrow == n-1 && ncol == m-1) {
                return dis+1;
             }
             q.add(new tuple(dis+1, nrow, ncol));
           }
           }
        }
        return -1;
    }
}