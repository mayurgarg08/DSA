class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> st = new HashMap<>();
        int prefixSum = 0;
        st.put(0, 1);
        int cnt = 0;
        for(int i = 0; i< n; i++) {
            prefixSum += nums[i];
            int x = prefixSum - k;
            if(st.containsKey(x)) {
                cnt += st.get(x);
            }
            st.put(prefixSum, st.getOrDefault(prefixSum, 0) + 1);
        }
        return cnt;
    }
}