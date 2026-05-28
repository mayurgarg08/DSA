class Solution {
    public int numberOfSpecialChars(String word) {
         int count = 0;
         int lastLower = -1;
         int firstUpper = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) 
        {
            lastLower = word.lastIndexOf(ch);
            firstUpper = word.indexOf(Character.toUpperCase(ch));
            if (lastLower != -1 && firstUpper != -1 && lastLower < firstUpper) 
            {
                count++;
            }
        }
        return count;
    }
}