class Solution {
    private int maxi(int[] arr) {
        int maxim = Integer.MIN_VALUE;
        for(int num: arr) {
            maxim = Math.max(maxim, num);
        }
        return maxim;
    }
    private int sum(int[] arr) {
        int sum = 0;
        for(int num: arr) {
            sum += num;
        }
        return sum;
    }
    private int findDays(int[] weights, int cap) {
        int days = 1;
        int load = 0;
        for(int weight: weights) {
            if(weight + load > cap) {
                days += 1;
                load = weight;
            } else load += weight;
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = maxi(weights);
        int high = sum(weights);

        while(low <= high) {
            int mid = (high+low)/2;
            if(findDays(weights, mid) <= days) {
                 high = mid-1;
            } else low = mid+1;
        }
        return low;
    }
}