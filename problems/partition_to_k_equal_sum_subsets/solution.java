class Solution {
    public boolean canPartitionKSubsets(int[] arr, int K) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += arr[i];
        if(sum % K != 0) return false;
        int target = sum/K;
        boolean[] used = new boolean[n];
        return backTrack(arr, used, K, 0, 0, target);
    }
    private boolean backTrack(int[] arr, boolean[] used, int k, int start, int currSum, int target) {
        if(k == 1) return true;
        if(currSum == target) return backTrack(arr, used, k-1, 0, 0, target);
        for(int i = start; i < arr.length; i++) {
            if(currSum + arr[i] > target) continue;
            if(used[i]) continue;
            used[i] = true;
            if(backTrack(arr, used, k, i+1, currSum + arr[i], target)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}