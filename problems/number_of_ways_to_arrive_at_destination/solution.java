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

        for(int[] r : roads) {
            adj.get(r[0]).add(new Pair(r[1], r[2]));
            adj.get(r[1]).add(new Pair(r[0], r[2]));
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        long[] dist = new long[n];
        int[] ways = new int[n];
        int MOD = (int)1e9 + 7;
        long INF = (long)1e18;

        Arrays.fill(dist, INF);
        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            long dis = p.dist;
            int node = p.node;

            if(dis > dist[node]) continue;

            for(Pair it : adj.get(node)) {
                int adjNode = it.node;
                long edw = it.dist;

                if(dis + edw < dist[adjNode]) {
                    dist[adjNode] = dis + edw;
                    pq.add(new Pair(adjNode, dis + edw));
                    ways[adjNode] = ways[node];
                }
                else if(dis + edw == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1] % MOD;
    }
}
