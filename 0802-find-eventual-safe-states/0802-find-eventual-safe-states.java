class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       List<Integer> ans = new ArrayList<>();
       List<List<Integer>> adj = new ArrayList<>();
       Queue<Integer> q = new LinkedList<>();
       int n = graph.length;
       for(int i = 0; i < n; i++) {
          adj.add(new ArrayList<>());
       }
       int[] indegree = new int[n];
       for(int i = 0; i < n; i++) {
          for(int it : graph[i]) {
            adj.get(it).add(i);
            indegree[i]++;
          }
       }
       for(int i = 0; i < n; i++) {
         if(indegree[i] == 0) q.offer(i);
       }
       while(!q.isEmpty()) {
          int node = q.poll();
          ans.add(node);
          for(int it : adj.get(node)) {
            indegree[it]--;
            if(indegree[it] == 0) q.offer(it);
          }
       }
       Collections.sort(ans);
       return ans;
    }
}