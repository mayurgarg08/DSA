class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());  
        }
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i++) {
            for(int it : graph[i]) {
                adj.get(it).add(i);
                indegree[i]++;
            }
        }
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            for(int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        Collections.sort(topo);
        return topo;
    }
}