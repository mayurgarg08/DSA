class Solution {
    public int balancedString(String s) {
        int n = s.length();
       int[] count = new int[128];
       for(char c : s.toCharArray()) {
        count[c]++;
       }
       int left = 0;
       int ans = n;
       int k = n/4;
       for(int right = 0; right < n; right++) {
          count[s.charAt(right)]--;
          while(left < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
            ans = Math.min(ans, right-left+1);
            count[s.charAt(left)]++;
            left++;
          }
       }
       return ans;
    }
}