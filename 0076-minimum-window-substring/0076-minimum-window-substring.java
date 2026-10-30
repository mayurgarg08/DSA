class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) return "";
        int[] hash = new int[256];
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        int count = 0;
        for(char c: t.toCharArray()) hash[c]++;
        for(int right = 0; right < n; right++) {
            if(hash[s.charAt(right)] > 0) count++;
            hash[s.charAt(right)]--;
            while(count == m) {
                if((right-left+1) < minLen) {
                  minLen = right-left+1;
                  start = left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0) count--;
                left++;
            } 
        }
      if(minLen == Integer.MAX_VALUE) return "";
     return s.substring(start, start+minLen); 
    }
}