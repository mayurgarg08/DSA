class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for(int key: map.keySet()) {
            List<Integer> temp = map.get(key);
            for(int j = 0; j + 2 < temp.size(); j++) {
                int  p = temp.get(j);
                int q = temp.get(j+1);
                int r = temp.get(j+2);

                int sum = Math.abs(p-q) + Math.abs(q-r) + Math.abs(r-p);
                minSum = Math.min(sum, minSum);
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}