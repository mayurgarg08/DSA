class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        int oddCount = 0;
        for (int x : nums1) 
            {
                min = Math.min(min,x);
                if (x % 2 == 1) oddCount++;
            }
            if (oddCount == 0 || oddCount == nums1.length) 
            {
                return true;
            }
        return min % 2 == 1;
    }
}