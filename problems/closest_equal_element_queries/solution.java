class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> mpp = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            mpp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int qIdx = queries[i];
            int val = nums[qIdx];
            List<Integer> indices = mpp.get(val);

            if (indices.size() == 1) {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(indices, qIdx);
            int k = indices.size();

            int prevIdx = indices.get((pos - 1 + k) % k);
            int nextIdx = indices.get((pos + 1) % k);

            int distLeft = (qIdx - prevIdx + n) % n;
            int distRight = (nextIdx - qIdx + n) % n;

            ans.add(Math.min(distLeft, distRight));
        }

        return ans;
    }
}