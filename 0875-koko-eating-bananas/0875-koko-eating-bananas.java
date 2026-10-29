class Solution {
    private int cntHours(int[] piles, int mid) {
        int hrs = 0;
        for(int i = 0; i < piles.length; i++) {
            hrs += Math.ceil((double)(piles[i])/(double)(mid));
        }
        return hrs;
    }
    private int maxEl(int[] arr) {
        int n = arr.length;
        int maxEl = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, arr[i]);
        }
        return maxEl;
    }
    public int minEatingSpeed(int[] piles, int h) {
       int n = piles.length;
       int low = 1;
       int high = maxEl(piles);
       while(low <= high) {
          int mid = (low+high)/2;
          int hrs = cntHours(piles, mid);
          if(hrs > h) {
            low = mid+1;
          } else {
            high = mid-1;
          }
       }
       return low;
    }
}