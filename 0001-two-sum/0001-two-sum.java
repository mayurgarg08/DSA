class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap<Integer, Integer> map = new HashMap<>();
         int n = nums.length;
         int[] ans = new int[2];
         for(int i = 0; i < n; i++) {
            if(map.containsKey(target-nums[i])) {
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
         }
         return ans;
    }
}