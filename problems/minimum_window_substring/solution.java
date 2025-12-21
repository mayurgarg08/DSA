class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
         if (m > n) return "";
        int l = 0, r = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int[] hash = new int[256];
        Arrays.fill(hash, 0);
        for(int i = 0; i< m; i++) {
            hash[t.charAt(i)]++;
        }
        while(r<s.length()) {
            if(hash[s.charAt(r)] > 0) count += 1;
            hash[s.charAt(r)]--;

            while(count == m) {
               if(r-l+1 < minLen) {
                minLen = r-l+1;
                sIndex = l;
               }
              hash[s.charAt(l)]++;
              if(hash[s.charAt(l)] > 0) count = count-1;
              l++;
            }
            r++;
        }
        return sIndex == -1?"":s.substring(sIndex, sIndex+minLen);
    }
}