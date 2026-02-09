class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int mid = (n-1)/2;
        for(int i = 0; i <= mid; i++) {
            char c =  s[n-(1+i)];
            s[n-(1+i)] = s[i];
            s[i] = c;
        }
    }
}