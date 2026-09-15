class Solution {
    public int findContentChildren(int[] g, int[] s) {
       int n = g.length;
       int m = s.length;
       int count = 0;
       Arrays.sort(g);
       Arrays.sort(s);
       int p = 0;
       for(int i = 0; i < m; i++) {
        if(p < n && s[i] >= g[p]) {
            count++;
            p++;
        }
       }
       return count;
    }
}