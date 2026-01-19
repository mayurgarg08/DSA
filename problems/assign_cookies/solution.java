class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sIndex= 0;
        int gIndex = 0;

        while(sIndex < s.length && gIndex < g.length) {
            if(s[sIndex] >= g[gIndex]) {
                gIndex++;
            }
            sIndex++;
        } 
        return gIndex;
    }
}