class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0) {
            return t.charAt(0);
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i =0; i<a.length; i++) {
            if(a[i] != b[i]) {
                return b[i];
            }
        }
        return b[b.length-1];
    }
}