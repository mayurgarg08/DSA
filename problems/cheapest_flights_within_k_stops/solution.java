class Tuple {
    int stops;
    int node;
    int cost;
    Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}
class Pair {
    int node;
    int dist;
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         List<List<Pair>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
         }
         int m = flights.length;
         for(int i = 0; i< m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
         } 

         Queue<Tuple> q  = new LinkedList<>();
         
         int[] dist = new int[n];

         for(int i = 0; i< n; i++) {
            dist[i] = (int)1e9;
         }

         dist[src]  =0;
         q.add(new Tuple(0, src, 0));

         while(!q.isEmpty()) {
            int stops = q.peek().stops;
            int node = q.peek().node;
            int cost = q.peek().cost;
            q.remove();

            if(stops > k) continue;
            for(Pair it : adj.get(node)) {
                int adjNode  = it.node;
                int edw = it.dist;

                if(cost + edw  < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edw;
                    q.add(new Tuple(stops + 1, adjNode, dist[adjNode]));
                }
            }
         }
         if(dist[dst] == (int)1e9) return -1;
         return dist[dst];
    }
}