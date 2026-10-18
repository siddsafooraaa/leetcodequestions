class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2][3];
         for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0,1,2,prices);
    }
    public int solve(int i,int buy,int count,int[] prices){
        if(i==prices.length){
            return 0;
        }
        if(count==0){
            return 0;
        }
        if(dp[i][buy][count]!=-1){
            return dp[i][buy][count];
        }
        int profit=0;
        if(buy==1){
            int take=-prices[i]+solve(i+1,0,count,prices);
            int nottake=0+solve(i+1,1,count,prices);
            profit= Math.max(take,nottake);
        }else{
            int take=prices[i]+solve(i+1,1,count-1,prices);
            int nottake=0+solve(i+1,0,count,prices);
            profit= Math.max(take,nottake);
        }
        return dp[i][buy][count]=profit;
    }
}