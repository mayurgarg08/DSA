class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        int[] prev = new int[m+1];
        for(int idx1 = 1; idx1 <= n; idx1++) {
            int[] curr = new int[m+1];
            for(int idx2 = 1; idx2 <= m; idx2++) {
                
                 if(nums1[idx1-1] == nums2[idx2-1]) {
                     curr[idx2] = 1 + prev[idx2-1];
                     ans = Math.max(ans, curr[idx2]);
                 }
                 else curr[idx2] = 0;
            }
            prev = curr;
        }
        return ans;
    }
}