class Solution {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[] next = new boolean[target+1];
        next[0] = true;
        for(int sum = 0; sum <= target; sum++) {
            if(sum == target) {
                next[sum] = true;
            } else {
                next[sum] = false;
            }
        }
        for(int idx = n-1; idx >= 0; idx--) {
            boolean[] curr = new boolean[target+1];
            for(int sum = 0; sum <= target; sum++) {
                boolean take = false;
                if(sum + arr[idx] <= target) take = next[sum+arr[idx]];
                boolean notTake = next[sum];
                curr[sum] = take || notTake;
            }
            next = curr;
        }
        return next[0];
    }
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int totSum = 0;
        for(int i = 0; i < n; i++) {
            totSum += stones[i];
        }
        int target = totSum/2;
        int s1 = 0;
        for(int sum = target; sum >= 0; sum--) {
            if(isSubsetSum(stones, sum)) {
                s1 = sum;
                break;
            }
        }
        int s2 = totSum - s1;
        return s2-s1;
    }
}