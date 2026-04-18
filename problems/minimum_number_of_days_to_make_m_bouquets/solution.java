class Solution {
    private int maxi(int[] piles) {
        int maxim = Integer.MIN_VALUE;
        for(int num: piles) {
            maxim = Math.max(maxim, num);
        }
        return maxim;
    }
    private int mini(int[] piles) {
        int minim = Integer.MAX_VALUE;
        for(int num: piles) {
            minim = Math.min(minim, num);
        }
        return minim;
    }
    private boolean possible(int[] bloomday, int mid, int m, int k) {
        int count = 0;
        int number  = 0;
        for(int num: bloomday) {
            if(num <= mid) count++;
            else {
                 number += count/k;
                count = 0; 
             }
        } 
        number += count/k;
        if(number >= m) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = mini(bloomDay);
        int high = maxi(bloomDay);
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(possible(bloomDay, mid, m, k) == true) {
                ans = mid;
                high = mid-1;
            } else low = mid+1;
        }
        return ans;
    }
}