class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
       
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        backtrack(index + 1, nums, curr, res);

        curr.add(nums[index]);
        backtrack(index + 1, nums, curr, res);
        curr.remove(curr.size() - 1);
    }
}
