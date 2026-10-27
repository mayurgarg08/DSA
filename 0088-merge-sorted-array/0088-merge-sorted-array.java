class Solution {
    private void swap(int i, int ptr, int[] nums1, int[] nums2) {
        int temp = nums1[i];
        nums1[i] = nums2[ptr];
        nums2[ptr] = temp;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         if(n == 0) return;
         Arrays.sort(nums1, 0, m);
         Arrays.sort(nums2);
         int ptr = 0;
         for(int i = 0; i < m+n; i++) {
            if(i >= m) {
                nums1[i] = nums2[ptr];
                ptr++;
            }
             else if(nums1[i] <= nums2[ptr]) continue;
             else {
                swap(i, ptr, nums1, nums2);
                Arrays.sort(nums2);
             }
         }
    }
}