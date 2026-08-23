class Solution {
    public int subarraySum(int[] nums, int k) {
      int n = nums.length;
      HashMap<Integer, Integer> map = new HashMap<>();
      int sum = 0;
      int count = 0;
      map.put(0, 1);
      
     for(int i = 0; i < n; i++) {
         sum += nums[i];
         int x = sum - k;
         if(map.containsKey(x)) {
            count += map.get(x);
         }
         map.put(sum, map.getOrDefault(sum, 0) + 1);
     }
     return count;
    }
}