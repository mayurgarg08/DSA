class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        int n = s.length();
        for(int i = 0; i<n; i++){
            freq[s.charAt(i) - 'a']++;
        }
        int len = 0;
        for(int i : freq){
            if(i == 0) continue;
            len += (i & 1 ^ 1)<<1 | i & 1;
        }
        return len;
    }
}