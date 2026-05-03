class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int even = 0, odd = 0;
        for(int num : nums) 
        {
            if(num % 2 == 0)
                even++;
            else 
                odd++;
        }
        for(int i = 0; i < n; i++) 
            {
                if(nums[i] % 2 == 0)
                {
                    even--;
                    ans[i] = odd;
                }
                else
                {
                    odd--;
                    ans[i] = even;
                }
            }
        return ans;
    }
}