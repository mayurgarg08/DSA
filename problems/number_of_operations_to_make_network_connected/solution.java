class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
      for(int i = 0; i <n; i++) {
        size.add(1);
        parent.add(i);
        rank.add(0);
      }
    }

    public int findPar(int node) {
        if(node == parent.get(node)) return node;
         int ultimateParent = findPar(parent.get(node));
    parent.set(node, ultimateParent);  
    return ultimateParent;
    }
    public boolean find(int u, int v) {
        return findPar(u) == findPar(v);
    }

    public void unionByRank(int u, int v) {
        int par_u = findPar(u);
        int par_v = findPar(v);
        if(par_u == par_v) return;
        if(rank.get(par_u) < rank.get(par_v)) {
            parent.set(par_u, par_v);
        }  else if(rank.get(par_v) < rank.get(par_u)) {
            parent.set(par_v, par_u);
        } else {
            parent.set(par_v, par_u);
            int rank_u = rank.get(par_u);
            rank.set(par_u, rank_u+1);
        }
    }

    public void unionBySize(int u, int v) {
        int par_u = findPar(u);
        int par_v = findPar(v);
        if(par_u == par_v) return;
        if(size.get(par_u) < size.get(par_v)) {
            parent.set(par_u, par_v);
            size.set(par_v, size.get(par_v)+ size.get(par_u));
        } else {
            parent.set(par_v, par_u);
            size.set(par_u, size.get(par_u) + size.get(par_v));
        } 
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extras = 0;
        int m = connections.length;
        for(int i = 0; i< m; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findPar(u) == ds.findPar(v)) {
                extras++;
            } else {
                ds.unionBySize(u,v);
            }
        }
        int cntC = 0;
        for(int i = 0; i< n; i++) {
            if(ds.parent.get(i) == i) cntC++;
        }
        int ans = cntC -1;
        if(extras >= ans) return ans;
        return -1;
    }
}