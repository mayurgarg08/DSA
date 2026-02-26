class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1;
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        
        for (int i = 0; i < n; i++) {

            int j = i - 1;
            int k = i + 1;
            int count = 1;
            StringBuilder temp = new StringBuilder();
            temp.append(s.charAt(i));

            while (j >= 0 && k < n) {
                if (s.charAt(j) == s.charAt(k)) {
                    count += 2;
                    temp.insert(0, s.charAt(j));
                    temp.append(s.charAt(k));
                    if (count > maxLen) {
                        ans = new StringBuilder(temp); // copy
                        maxLen = count;
                    }
                    j--;
                    k++;
                } else {
                    break; 
                }
            }

            j = i;
            k = i + 1;
            count = 0;
            temp = new StringBuilder();

            while (j >= 0 && k < n) {
                if (s.charAt(j) == s.charAt(k)) {
                    count += 2;
                    temp.insert(0, s.charAt(j));
                    temp.append(s.charAt(k));
                    if (count > maxLen) {
                        ans = new StringBuilder(temp); // copy
                        maxLen = count;
                    }
                    j--;
                    k++;
                } else {
                    break; 
                }
            }
        }
        return ans.toString();
    }
}