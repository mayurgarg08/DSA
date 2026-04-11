class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            String num = Integer.toString(nums[i]);
            for(char c: num.toCharArray()) {
                if(c == (char)(digit + '0')) count++;
            }
        }
        return count;
    }
}