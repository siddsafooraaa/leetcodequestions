class Solution {
    int n;
    int[][] dp;
    public boolean canPartition(int[] nums) {
        n=nums.length;
        int sum=Arrays.stream(nums).sum();
        if(sum%2!=0){
            return false;
        }
        int x=sum/2;
       dp = new int[n][x + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(0,nums,x);
    }
    public boolean solve(int i,int[] nums,int x){
        if(i>=nums.length){
            return false;
        }
        if(x==0){
            return true;
        }
        if(dp[i][x]!=-1){
            return dp[i][x]==1;
        }
        boolean take=false;
        if(nums[i]<=x){
             take=solve(i+1,nums,x-nums[i]);
        }
        boolean skip=solve(i+1,nums,x);
        boolean ans=take|| skip;
      if (ans) {
            dp[i][x] = 1;
        } else {
            dp[i][x] = 0;
        }
        return ans;
}
}