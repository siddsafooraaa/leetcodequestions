class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp=new int[prices.length+2][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0, 1, prices);
    }
    public int solve(int i, int buy, int[] prices) {
        if (i == prices.length) {
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int profit;
        if (buy == 1) {
            int take = -prices[i] + solve(i + 1, 0, prices);
            int nottake = solve(i + 1, 1, prices);
            profit = Math.max(take, nottake);
        } else {
            int take = prices[i] + solve(i + 2, 1, prices);
            int nottake = solve(i + 1, 0, prices);
            profit = Math.max(take, nottake);
        }
        return dp[i][buy]=profit;
    }
}


