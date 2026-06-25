class Solution {
    private void helper(int idx, int[] arr, int target, List<Integer> curr, List<List<Integer>> ans) {  
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }    
        if(idx == 0) {
            if(target % arr[0] == 0) {
                for(int i = 0; i < target / arr[0]; i++)
                    curr.add(arr[0]);

                ans.add(new ArrayList<>(curr));

                for(int i = 0; i < target / arr[0]; i++)
                    curr.remove(curr.size() - 1);
            }
            return;
        }

        helper(idx - 1, arr, target, curr, ans);

        if(arr[idx] <= target) {
            curr.add(arr[idx]);
            helper(idx, arr, target - arr[idx], curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(n-1, candidates, target, curr, ans);
        return ans;
    }
}