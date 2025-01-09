class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        for(int i = 0; i< boxes.length(); i++) {
            int opr = 0;
            for(int j = 0; j<i; j++) {
                if(boxes.charAt(j) == '1') {
                    opr += i-j;
                }
            }
            for(int j = i+1; j<boxes.length(); j++) {
                if(boxes.charAt(j) == '1') {
                    opr += j-i;
                    
                }
            }
            ans[i] = opr;
        }
        return ans;
    }
}