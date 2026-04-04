class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1) return encodedText;
        int n = encodedText.length();
        int columns = n/rows;

        char[][] matrix = new char[rows][columns];
        int index = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = encodedText.charAt(index);
                index++; 
            }
        }
       
        StringBuilder ans = new StringBuilder();

        for(int j = 0; j < columns; j++) {
            int r = 0;
            int c = j;
             while(r != rows && c != columns) {
                 ans.append(matrix[r][c]);
                 r++;
                 c++;
             }
        }
       int end = ans.length() - 1;
        while(end >= 0 && ans.charAt(end) == ' ') {
            end--;
        }

        return ans.substring(0, end + 1);
    }
}