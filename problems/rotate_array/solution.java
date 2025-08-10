class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int[] rotated = new int[n]; 
       for(int i = 0; i<n; i++) {
           rotated[(i+k)%n] = nums[i];
       }
       for(int j = 0; j< n; j++) {
        nums[j] = rotated[j];
       }
    }
}