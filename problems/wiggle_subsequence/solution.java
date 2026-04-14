class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return 1;
        int j = 1;
        while(j < nums.length && nums[j] == nums[j-1]) {
            j++;
        }
        if(j == nums.length) return 1;
        List<Integer> lst = new ArrayList<>();
        lst.add(nums[0]);
        lst.add(nums[j]);
        int diff = nums[j] > nums[0] ? 1 : 0;
        for(int i = j+1; i < nums.length; i++) {
            if(diff == 1) {
                if(nums[i] < lst.get(lst.size()-1)) {
                    diff = 0;
                    lst.add(nums[i]);
                } else {
                    lst.set(lst.size() - 1, nums[i]);
                }
            } else {
                if(nums[i] > lst.get(lst.size()-1)) {
                    diff = 1;
                    lst.add(nums[i]);
                } else lst.set(lst.size() - 1, nums[i]);
            }
        }
        return lst.size();
    }
}