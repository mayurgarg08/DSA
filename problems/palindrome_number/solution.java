class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int rem = 0;
        int ans = 0;
  
        while(x>0) {
            rem = x%10;
            ans = ans*10+rem;
            x = x/10;
        }
        if(original == ans) {
            return true;
        }
        return false;
    }
}