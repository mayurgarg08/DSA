class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int count = 0;
        int depth = 0;
        for(int i = 0; i< n; i++) {
            if(s.charAt(i) == '(') {
                depth++;
            } else {
                if(depth > 0) {
                    depth--;
                } else {
                    count++;
                }
            }
        }
        if(depth > 0) count+= depth;
        if(count < 0) {
            count = -count;
        }
        return count;
    }
}