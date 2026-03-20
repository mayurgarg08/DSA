class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];
        for(int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        int maxFreq = 0;
        int count = 0;
        for(int i = 0; i< freq.length; i++) {
            if(freq[i] > maxFreq) {
                maxFreq = freq[i];
                count = freq[i];
            } else if(freq[i] == maxFreq) {
                count += freq[i];
            } else {
                continue;
            }
        }
        return count;
    }
}