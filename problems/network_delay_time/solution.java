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
        for(int i = 0; i< m; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        q.add(new Pair(k, 0));
        int[] dist = new int[n+1];
        for(int i = 0; i<= n; i++) {
            dist[i] = (int)1e9;
        }
        dist[k] = 0;
        while(!q.isEmpty()) {
            int node = q.peek().node;
            int dis = q.peek().dist;
            q.remove();

            for(Pair it : adj.get(node)) {
                int nod = it.node;
                int edjw = it.dist;
                if(dis + edjw < dist[nod]) {
                    dist[nod] = dis + edjw;
                    q.add(new Pair(nod, dist[nod]));
                }
            }
        }
        int ans = 0;
for(int i = 1; i <= n; i++) {
    if(dist[i] == (int)1e9) return -1;
    ans = Math.max(ans, dist[i]);
}
return ans;

    }
}