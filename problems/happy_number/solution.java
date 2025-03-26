class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
       do{
         slow = findSquare(slow);
         fast = findSquare(findSquare(fast));
       } while(slow != fast);

     if(slow == 1) {
        return true;
     }
   return false;
    }

    private int findSquare(int n) {
        int ans = 0;
        if(n == 0) {
            return 0;
        } else {
          while(n>0) {
          int rem = n%10;
          ans += rem*rem;
          n = n/10;
        }
        }
        return ans;
    }
}