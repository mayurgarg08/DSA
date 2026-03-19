class Solution {
    public int distMoney(int money, int children) {
        if(money < children) return -1;
        money -= children;
        int max8 = Math.min(children, money/7);
        if(max8 == children && money != 7 * children) {
            return children-1;
        }

        if(max8 == children-1 && money%7 == 3) {
            return max8-1;
        }
        return max8;
    }
}