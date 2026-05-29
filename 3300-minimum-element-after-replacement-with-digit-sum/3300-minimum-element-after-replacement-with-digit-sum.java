class Solution {
    public int minElement(int[] nums) {
        int mini = Integer.MAX_VALUE;
        for(int num: nums) {
            int x = num;
            int sum = 0;
            while(x > 0) {
                int rem = x%10;
                sum += rem;
                x = x/10;
            }
            mini = Math.min(mini, sum);
        }
        return mini;
    }
}