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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        for(int i = 0; i< n; i++) {
            for(int j = 0; j< n; j++) {
               if(grid[i][j] == 0) continue;
               int[] drow = {-1, 0, 1, 0};
               int[] dcol = {0, 1, 0, -1};
               for(int k = 0; k < 4; k++) {
                int nrow = drow[k]+i;
                int ncol = dcol[k]+j;
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                    int nodeno = i*n + j;
                    int adjNo = nrow*n + ncol;

                    ds.unionBySize(nodeno, adjNo);
                }
               }
            }
        }
        int mx = 0;
        for(int i = 0; i< n; i++) {
            for(int j = 0; j< n; j++) {
               if(grid[i][j] == 1) continue;
               int[] drow = {-1, 0, 1, 0};
               int[] dcol = {0, 1, 0, -1};
               HashSet<Integer> comp = new HashSet<>();

               for(int k = 0; k < 4; k++) {
                int nrow = drow[k]+i;
                int ncol = dcol[k]+j;
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                    comp.add(ds.findPar(nrow*n + ncol));
                }
               }
               int sizeT = 0;
               for(int parent : comp) {
                sizeT += ds.size.get(parent);
               }
               mx = Math.max(mx, sizeT+1);
            }
        }
        for(int cell = 0; cell < n*n; cell++) {
            mx = Math.max(mx, ds.size.get(ds.findPar(cell)));
        }
        return mx;
    }
}