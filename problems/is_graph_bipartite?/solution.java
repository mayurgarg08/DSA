class Solution {
    private boolean bfs(int start, int[] color, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for(int it : graph[node]) {
                if(color[it] == -1) {
                    color[it] = color[node] == 0?1:0;
                    q.add(it);
                } else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        for(int i = 0; i< v; i++) color[i] = -1;

        for(int i = 0; i< v; i++) {
            if(color[i] == -1) {
                if(bfs(i, color, graph) == false) return false;
            }
        }
        return true;
    }
}