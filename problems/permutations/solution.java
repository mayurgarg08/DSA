class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, 0, ans);
        return ans;
    }
    private void permute(int[] nums, int start, List<List<Integer>> ans) {
        if(start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int n : nums) temp.add(n);
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, start+1, ans);
            swap(nums, i, start);
        }
    }
    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}