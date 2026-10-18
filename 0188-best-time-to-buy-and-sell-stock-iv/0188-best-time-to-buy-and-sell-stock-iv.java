class Solution {
     int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp=new int[prices.length][2][k+1];
         for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,1,k,prices);
    }
    public int solve(int i,int buy,int k,int[] prices){
        if(i==prices.length){
            return 0;
        }
        if(k==0){
            return 0;
        }
        if(dp[i][buy][k]!=-1){
            return dp[i][buy][k];
        }
        int profit=0;
        if(buy==1){
            int take=-prices[i]+solve(i+1,0,k,prices);
            int nottake=0+solve(i+1,1,k,prices);
            profit= Math.max(take,nottake);
        }else{
            int take=prices[i]+solve(i+1,1,k-1,prices);
            int nottake=0+solve(i+1,0,k,prices);
            profit= Math.max(take,nottake);
        }
        return dp[i][buy][k]=profit;
    }
}