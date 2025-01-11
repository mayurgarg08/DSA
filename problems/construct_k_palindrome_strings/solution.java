class Solution {
    public boolean canConstruct(String s, int k) {
       int[] freq = new int[26];
        if(s.length()<k) {
            return false;
        }
        for(int i =0; i< s.length(); i++) {
            freq[s.charAt(i)-'a']++;
        }
        int odd =0;
        for(int i = 0; i<freq.length; i++) {
            if(freq[i]%2 != 0) {
                odd++;
            }
        }
        if(odd<=k) return true;
        return  false;

    }
}