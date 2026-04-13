class Solution {
   private String swap(String s1, int ptr1, int ptr2) {
    StringBuilder sb = new StringBuilder(s1);
    
    char temp = sb.charAt(ptr1);
    sb.setCharAt(ptr1, sb.charAt(ptr2));
    sb.setCharAt(ptr2, temp);

    return sb.toString();
  }
    public boolean canBeEqual(String s1, String s2) {
        if(s1.charAt(0) != s2.charAt(0)) {
           s1 = swap(s1, 0, 2);
        }

        if(s1.charAt(1) != s2.charAt(1)) {
           s1 = swap(s1, 1, 3);
        }

        return s1.equals(s2);
    }
}