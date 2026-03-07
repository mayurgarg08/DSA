class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int perimeter = 0;
        int[] drow = new int[] {-1, 0, 1, 0};
        int[] dcol = new int[] {0, 1, 0, -1};
       for(int  i = 0; i< n; i++) {
        for(int j = 0; j< m; j++) {
              if(grid[i][j] == 1) {   // land cell

                    for(int k = 0; k < 4; k++) {

                        int nrow = i + drow[k];
                        int ncol = j + dcol[k];

                        // agar grid ke bahar hai ya water hai
                        if(nrow < 0 || ncol < 0 || nrow >= n || ncol >= m || grid[nrow][ncol] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
       }
        return perimeter;
        }
    }