class Solution {
    private int reverse(int num) {
        int rev = 0;
        while(num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                minDist = Math.min(minDist, i - index);
            }
            int rev = reverse(nums[i]);
            map.put(rev, i);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}