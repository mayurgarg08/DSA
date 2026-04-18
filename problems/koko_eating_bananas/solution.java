class Solution {
    private int maxi(int[] piles) {
        int maxim = Integer.MIN_VALUE;
        for(int num: piles) {
            maxim = Math.max(maxim, num);
        }
        return maxim;
    }
    private int calHours(int[] piles, int mid) {
        int totHours = 0;
        for(int num: piles) {
            totHours += Math.ceil((double)(num)/ (double)(mid));
        }
        return totHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxi(piles);
        int ans = 0;
        while(low <= high) {
            int mid = (high+low)/2;
            int val = calHours(piles, mid);
            if(val <= h) {
                ans = mid;
                high = mid-1;
            } else low = mid+1;
        }
        return ans;
    }
}