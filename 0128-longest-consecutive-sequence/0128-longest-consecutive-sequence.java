class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        int n = nums.length;
        int maxCount = 0;
         for(int num : nums) {
            map.add(num);
        }
      for(int it : map) {
            if(map.contains(it - 1) == false) {
                int cnt = 1;
                int x = it;
                while(map.contains(x+1) == true) {
                    cnt++;
                    x = x+1;
                }
                maxCount = Math.max(maxCount, cnt);
            }
        }
        return maxCount;
    }
}