class Solution {
    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
          int[] dp=new int[n+1];
          return solve(n,dp);
    }
    int solve(int n,int[] dp){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
    }
    if(dp[n]!=0){
        return dp[n];
    }
    int onestep=solve(n-1,dp);
    int twostep=solve(n-2,dp);
    return dp[n]=onestep+twostep;
}
}