class Solution {
     private int  noStudents(int[] nums, int pages) {
        int students = 1;
        int pageStudents = 0;
        for(int num: nums) {
            if(pageStudents + num <= pages) {
                pageStudents += num;
            } else {
                students++;
                pageStudents = num;
            }
        }
        return students;
    }
    private int max(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for(int num : nums) {
            maxi = Math.max(maxi, num);
        }
        return maxi;
    } 
    private int sum(int[] nums) {
        int sum = 0;
        for(int  num: nums) {
            sum += num;
        }
        return sum;
    }
    public int findPages(int[] nums, int m) {
         int low = max(nums);
         int high = sum(nums);
         while(low <= high) {
            int mid = (high+low)/2;
            int cntStudents = noStudents(nums, mid);
            if(cntStudents > m) low = mid+1;
            else high = mid-1; 
         }
         return low;
    }
    public int splitArray(int[] nums, int k) {
        return findPages(nums, k);
    }
}