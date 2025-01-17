class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorResult = 0;
        
        // XOR all the elements of the derived array
        for (int num : derived) {
            xorResult ^= num;
        }
        
        // If the result is 0, a valid original array exists, otherwise it doesn't
        return xorResult == 0;
    }
}