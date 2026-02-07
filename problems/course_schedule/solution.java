class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] it : prerequisites) {
            adj.get(it[1]).add(it[0]);
        }
        int[] indegree = new int[n];
        for(int i = 0; i< n; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        // int[] topo = new int[n];
        // int idx = 0;
        int count = 0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            count++;
            for(int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return count == n;
    }
}