class Solution {
    public int sumOfPrimesInRange(int n) {
        int r = 0, temp = n;
        while(temp > 0) 
            {
                r = r*10 + temp%10;
                temp /= 10;
            }
        int left = Math.min(n, r);
        int right = Math.max(n, r);
        int sum = 0;
        for (int i = left; i <= right; i++) 
            {
                if(isPrime(i))
                    sum += i;
            }
        return sum;
    }
    private boolean isPrime(int x) {
        if(x < 2) 
            return false;
        for(int i = 2; i*i <= x; i++) 
        {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}