class Pair {
    int node;
    int dist;
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       List<List<Pair>> adj = new ArrayList<>();
       for(int i = 0; i <= n; i++) {
          adj.add(new ArrayList<>());
       }       
       int m = times.length;
       for(int i = 0; i < m; i++) {
          int u = times[i][0];
          int v = times[i][1];
          int dist = times[i][2];

          adj.get(u).add(new Pair(v, dist));
       }
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
       int[] dist = new int[n+1];
       Arrays.fill(dist, (int)1e9);
       dist[k] = 0;
       pq.offer(new Pair(k, 0));
       while(pq.size() != 0) {
          int node = pq.peek().node;
          int dis = pq.peek().dist;
          pq.remove();

          for(Pair it : adj.get(node)) {
             int adjNode = it.node;
             int edW = it.dist;
             if(dist[node] + edW < dist[adjNode]) {
                dist[adjNode] = dist[node] + edW;
                pq.offer(new Pair(adjNode, dist[adjNode]));
             }
          }
       }
       int max = 0;
       for(int i = 1; i <= n; i++) {
          if(dist[i] == 1e9) return -1;
          max = Math.max(max, dist[i]);
       }
       return max;
    }
}