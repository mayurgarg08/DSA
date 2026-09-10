class Solution {
    private void helper(int index, int n, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));

        for(int i = index; i < n; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            helper(i+1, n, nums, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       int n = nums.length;
       List<List<Integer>> ans = new ArrayList<>();
       helper(0, n, nums, new ArrayList<>(), ans);
       return ans;
    }
}