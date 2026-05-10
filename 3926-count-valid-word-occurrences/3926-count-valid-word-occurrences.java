class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder();
        for (String chunk : chunks) {
            sb.append(chunk);
        }

        String s = sb.toString();
        Map<String, Integer> freq = new HashMap<>();
        int n = s.length();
        int i = 0;

        while (i < n) {
            if (!Character.isLowerCase(s.charAt(i))) {
                i++;
                continue;
            }

            StringBuilder word = new StringBuilder();
            while (i < n) {

                char ch = s.charAt(i);
                if (Character.isLowerCase(ch)) {
                    word.append(ch);
                    i++;
                }
                else if (ch == '-'
                        && i > 0
                        && i < n - 1
                        && Character.isLowerCase(s.charAt(i - 1))
                        && Character.isLowerCase(s.charAt(i + 1))) {

                    word.append(ch);
                    i++;
                }
                else {
                    break;
                }
            }

            String validWord = word.toString();

            if (!validWord.isEmpty()) {
                freq.put(validWord, freq.getOrDefault(validWord, 0) + 1);
            }
            while (i < n &&
                  !(Character.isLowerCase(s.charAt(i)))) {
                i++;
            }
        }
        int[] ans = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            ans[j] = freq.getOrDefault(queries[j], 0);
        }

        return ans;
    }
}