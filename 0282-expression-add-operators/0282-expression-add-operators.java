class Solution {

    private void helper(int index, String num, long value, long prev,
                        StringBuilder exp, int target, List<String> ans) {

        if(index == num.length()) {
            if(value == target)
                ans.add(exp.toString());
            return;
        }

        for(int i = index; i < num.length(); i++) {

            if(i > index && num.charAt(index) == '0')
                break;

            String s = num.substring(index, i + 1);
            long curr = Long.parseLong(s);

            int len = exp.length();

            if(index == 0) {
                exp.append(s);
                helper(i + 1, num, curr, curr, exp, target, ans);
                exp.setLength(len);
            }
            else {
                exp.append("+").append(s);
                helper(i + 1, num, value + curr, curr,
                       exp, target, ans);
                exp.setLength(len);

                exp.append("-").append(s);
                helper(i + 1, num, value - curr, -curr,
                       exp, target, ans);
                exp.setLength(len);

                exp.append("*").append(s);
                helper(i + 1, num, value - prev + prev * curr,
                       prev * curr, exp, target, ans);
                exp.setLength(len);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        helper(0, num, 0, 0, new StringBuilder(), target, ans);
        return ans;
    }
}