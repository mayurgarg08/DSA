class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void helper(int idx, int[] nums, int n, List<List<Integer>> ans) {
        if(idx == n) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i < n; i++) {
            swap(i, idx, nums);
            helper(idx+1, nums, n, ans);
            swap(i, idx, nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, n, ans);
        return ans; 
    }
}