class Solution {
    public int[] maxValue(int[] nums) {
       int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int[] ans = new int[n];

        int start = 0;

        for (int i = 0; i < n - 1; i++) {
            if (prefixMax[i] <= suffixMin[i + 1]) {

                int compMax = Integer.MIN_VALUE;

                for (int j = start; j <= i; j++) {
                    compMax = Math.max(compMax, nums[j]);
                }

                for (int j = start; j <= i; j++) {
                    ans[j] = compMax;
                }

                start = i + 1;
            }
        }

        int compMax = Integer.MIN_VALUE;
        for (int j = start; j < n; j++) {
            compMax = Math.max(compMax, nums[j]);
        }

        for (int j = start; j < n; j++) {
            ans[j] = compMax;
        }

        return ans;
    }
}