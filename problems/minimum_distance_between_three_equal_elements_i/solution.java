class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minSum = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i); 
        }

        for(int key : map.keySet()) {
            List<Integer> lst = map.get(key);

            if(lst.size() >= 3) { 
                for(int i = 0; i + 2 < lst.size(); i++) {
                    int a = lst.get(i);
                    int b = lst.get(i + 1);
                    int c = lst.get(i + 2);

                    int sum = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);

                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}