class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() == 1) return s;

        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int index = 0;
        char[][] mat = new char[numRows][n];

        int flag = 0;
        int k = 1;

        for(int j = 0; j < n && index < n; j++) {
            if(flag == 0) {
                for(int i = 0; i < numRows && index < n; i++) {
                    mat[i][j] = s.charAt(index);
                    index++;
                }
                flag = 1;
            } else {
               for(int i = numRows - 2; i > 0 && index < n; i--) {
                    mat[i][j] = s.charAt(index++);
                }
                flag = 0;
            }
        }

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] != '\0') {
                    ans.append(mat[i][j]);
                }
            }
        }

        return ans.toString();
    }
}