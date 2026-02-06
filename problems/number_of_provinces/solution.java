class Solution {
    private void dfs(int node, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        for(int it : adj.get(node)) {
            if(!vis[it]) {
                dfs(it, vis, adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
       List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++) {
            adj.add(new ArrayList<>());
            for(int j = 0; j < m; j++) {
              if(!(i == j) && isConnected[i][j] == 1) {
                adj.get(i).add(j);
              }
            }
        } 
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i< n; i++) {
          if(!vis[i]) {
            count++;
            dfs(i, vis, adj);
          }  
        }
        return count;
    }
}