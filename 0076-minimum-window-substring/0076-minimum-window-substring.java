class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int count = 0;
        if(n < m) return "";
        int l = 0;
        int r = 0;
        int start = 0;
        int[] hash = new int[256];
        int minLen  = Integer.MAX_VALUE;
        Arrays.fill(hash, 0);
        for(int i = 0; i < m; i++) hash[t.charAt(i)]++;
        while(r < n) {
           if(hash[s.charAt(r)] > 0) count++;
           hash[s.charAt(r)]--;
           while(count == m) {
            if((r-l+1) < minLen) {
               minLen = r-l+1;
               start = l;
            } 
            hash[s.charAt(l)]++;
            if(hash[s.charAt(l)] > 0) count--;
            l++;
           } 
           r++;
        }
        if(minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLen);
    }
}