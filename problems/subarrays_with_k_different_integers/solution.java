class Solution {
    private int atMost(int[] nums, int k) {
       Map<Integer, Integer> mpp = new HashMap<>();
        int count = 0;
        int l = 0, r= 0;
        while(r<nums.length) {
           mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) +1);
           while(mpp.size() > k) {
            mpp.put(nums[l], mpp.get(nums[l])-1);
            if(mpp.get(nums[l]) == 0) {
                mpp.remove(nums[l]);
            }
            l++;
           }
           count += (r-l+1);
           r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);   
    }
}