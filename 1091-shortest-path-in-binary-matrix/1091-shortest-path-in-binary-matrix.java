class tuple {
    int dis;
    int row;
    int col;
    tuple(int dis, int row, int col) {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
         if(grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return -1;
        }
        int[][] dist = new int[n][m];
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(1, 0, 0));
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)(1e9));
        }
        dist[0][0] = 0;
        int[] drow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};
        while(!q.isEmpty()) {
            int distance = q.peek().dis;
            int row = q.peek().row;
            int col = q.peek().col;
             q.poll();

             if(row == n-1 && col == m-1) {
                return distance;
            }
            
            for(int i = 0; i < 8; i++) {
                int nrow = drow[i] + row;
                int ncol = dcol[i] + col;

                if(nrow >= 0 && ncol >= 0 && nrow < n &&  ncol < m && dist[nrow][ncol] > distance + 1 && grid[row][col] == 0) {
                    dist[nrow][ncol] = distance+1;
                    if(nrow == n-1 && ncol == m-1) {
                        return distance+1;
                    }
                    q.add(new tuple(distance+1, nrow, ncol));
                }
            }
        }
        return -1;
    }
}