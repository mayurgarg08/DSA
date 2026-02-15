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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mpp = new HashMap<>();
        for(int i = 0; i< n; i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if(mpp.containsKey(mail) == false) {
                    mpp.put(mail, i);
                } else {
                    ds.unionBySize(i, mpp.get(mail));
                }
            }
        }

        List<List<String>> mergedMail = new ArrayList<>();
        for(int i = 0; i< n; i++) {
            mergedMail.add(new ArrayList<String>());
        }
        for(Map.Entry<String, Integer> it : mpp.entrySet()) {
            String mail = it.getKey();
            int node = ds.findPar(it.getValue());
            mergedMail.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(mergedMail.get(i).size() == 0) continue;
            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergedMail.get(i)) {
                temp.add(it);
            }
            ans.add(temp);
       }
       return ans;
    }
}