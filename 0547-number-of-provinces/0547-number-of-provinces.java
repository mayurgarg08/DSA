class Solution {
    private void dfs(int node, int[] vis, int[][] isConnected, int m) {
        vis[node] = 1; 
        for(int i = 0; i < m; i++) {
            if(isConnected[node][i] == 1) {
                if(vis[i] == 0) {
                    dfs(i, vis, isConnected, m);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
       int m = isConnected[0].length;
       int count = 0;
       int[] vis = new int[n];
       for(int i = 0; i < n; i++) {
          if(vis[i] == 0) {
            count++;
            dfs(i, vis, isConnected, m);
          }
       }
       return count;
    }
}