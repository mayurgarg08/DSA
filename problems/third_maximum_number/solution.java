class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = nums.length-1;
        while(list.size() <= 3 && i>=0) {
           
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
            }
            i--;
        
        }
         
        if(list.size() < 3) {
            return list.get(0);
        } else {
            return list.get(2);
        }
    
    }
}