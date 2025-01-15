class Solution {
    public int minimizeXor(int num1, int num2) {
       String y = Integer.toBinaryString(num1);
       String z = Integer.toBinaryString(num2);
        
       if(y.length() != z.length()) {
          while(y.length()<z.length()) {
            y = "0"+y;
          }
          while(z.length()<y.length()) {
            z = "0"+z;
          } 
        }

        StringBuilder a = new StringBuilder(y);
        StringBuilder b = new StringBuilder(z);

        int c = Integer.bitCount(num1);
        int d = Integer.bitCount(num2);

        if(c == d) {
          return num1;
        }

        int i = a.length()-1;
        while(c>d) {
         if(a.charAt(i) == '1') {
            a.setCharAt(i, '0');
            c--;
         }
         i--;
          
        }
        if(c == d) {
          return Integer.parseInt(a.toString(), 2);
        }
         while(d>c) {
         if(a.charAt(i) == '0') {
            a.setCharAt(i, '1');
             d--; 
         }
         i--;
        
        }
        if(c == d) {
          return Integer.parseInt(a.toString(), 2);
        }
        return Integer.parseInt(a.toString(), 2);
    }
}