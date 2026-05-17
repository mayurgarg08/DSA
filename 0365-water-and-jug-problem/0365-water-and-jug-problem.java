class Solution {
    Set<String> visited = new HashSet<>();
    public boolean canMeasureWater(int x, int y, int target) {
        return helper(0,0,x,y,target);
    }
    private boolean helper(int sum1,int sum2,
                           int x,int y,int target){
        if(sum1 + sum2 == target)
            return true;
        String state = sum1 + "," + sum2;
        if(visited.contains(state))
            return false;
        visited.add(state);

        boolean p1=false,p2=false,p3=false,p4=false;
        boolean p5=false,p6=false,p7=false,p8=false;

        p1=helper(x,sum2,x,y,target);
        p2=helper(sum1,y,x,y,target);
        p3=helper(0,sum2,x,y,target);
        p4=helper(sum1,0,x,y,target);

        if(sum2>=x-sum1)
            p5=helper(x,sum2-(x-sum1),x,y,target);

        if(sum1>=y-sum2)
            p6=helper(sum1-(y-sum2),y,x,y,target);

         int transfer1 = Math.min(sum2, x - sum1);
          p7 = helper(sum1 + transfer1, sum2 - transfer1, x, y, target);

        int transfer2 = Math.min(sum1, y - sum2);
         p8 = helper(sum1 - transfer2, sum2 + transfer2, x, y, target);

        return p1||p2||p3||p4||p5||p6||p7||p8;
    }
}