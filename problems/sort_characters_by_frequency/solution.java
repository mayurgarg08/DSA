class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[128];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        List<Character> list = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (!list.contains(ch)) {
                list.add(ch);
            }
        }

        Collections.sort(list, (a, b) -> freq[b] - freq[a]);

        StringBuilder ans = new StringBuilder();
        for (char ch : list) {
            for (int i = 0; i < freq[ch]; i++) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}