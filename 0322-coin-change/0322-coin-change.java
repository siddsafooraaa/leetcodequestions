class Solution {
    int n;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        n=coins.length;
        dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans= solve(n-1,coins,amount);
        if(ans>=1e9){
            return -1;
        }
        return ans;
    }
    public int solve(int index,int[] coins,int amount){
        if(index==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            return (int)1e9;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int skip=0+solve(index-1,coins,amount);
        int take=Integer.MAX_VALUE;
        if(coins[index]<=amount){
          take=1+solve(index,coins,amount-coins[index]);
        }
      return dp[index][amount]=Math.min(take,skip);
    }
}