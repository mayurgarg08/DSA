class Pair {
    int node;
    long dist;
    Pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];

            adj.get(u).add(new Pair(v, dist));
            adj.get(v).add(new Pair(u, dist));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        long[] ways = new long[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;
        q.offer(new Pair(0, 0));
        while(!q.isEmpty()) {
            Pair it = q.poll();
            int node = it.node;
            long dis = it.dist;

            for(Pair iter : adj.get(node)) {
                int adjNode = iter.node;
                long edW = iter.dist;

                if(dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    q.offer(new Pair(adjNode, dis + edW));
                    ways[adjNode] = ways[node];
                } else if(dist[adjNode] == dis + edW) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % 1000000007;
                }
            }
        }
        return (int)ways[n-1];
    }
}
