class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prevSorted = "";

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!sorted.equals(prevSorted)) {
                ans.add(word);
                prevSorted = sorted;
            }
        }

        return ans;
    }
}
