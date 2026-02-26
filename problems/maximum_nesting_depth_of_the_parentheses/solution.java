class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int maxCnt = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                cnt++;
                maxCnt = Math.max(cnt, maxCnt);
            } else if(s.charAt(i) == ')') {
                cnt--;
            }
        }
        return maxCnt;
    }
}