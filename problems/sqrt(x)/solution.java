class Solution {
    public int mySqrt(int x) {
        if(x == 1 || x== 0) {
            return x;
        }
        int start = 1;
        int end = x;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if((long)mid*mid < x) {
                start = mid+1;
        } else if((long)mid*mid == x) {
            return mid;
        } else if((long)mid*mid < x && (long)(mid+1)*(mid+1) > x) {
            return mid;
        } else if((long)mid*mid > x && (long)(mid-1)*(mid-1) < x) {
            return mid-1;
        } else {
                end = mid-1;
            }
        }
        return -1;
    }
}