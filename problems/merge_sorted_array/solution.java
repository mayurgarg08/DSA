class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int[] ans = new int[m+n];
       if(n == 0) {
        return;
       }
       if(m == 0 && n==1) {
        nums1[0] = nums2[0];
       }
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                ans[k] = nums1[i];
                i++;
            } else {
                ans[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<m) {
            ans[k] = nums1[i];
            i++;
            k++;
        }
        while(j<n) {
            ans[k] = nums2[j];
            j++;
            k++;
        }

        for(int l = 0; l< ans.length; l++) {
            nums1[l] = ans[l];
        }
    }
}