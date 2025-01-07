class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int count = 0;
        int[] ans = new int[queries.length];
        HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u')
        );
        
        int sum = 0;
        int[] prefixSum = new int[words.length];

        for(int i=0; i< words.length; i++) {
           String currentWord = words[i];
           
           if(vowels.contains(currentWord.charAt(0)) && vowels.contains(currentWord.charAt(currentWord.length()-1))) {
               sum++;
           }
           prefixSum[i] = sum;
        }

        for(int i = 0; i< queries.length; i++) {
            int[] currentQuery = queries[i];
            ans[i] = prefixSum[currentQuery[1]] - (currentQuery[0] == 0 ? 0 : prefixSum[currentQuery[0]-1]);
        }
     return ans;

    }
}