class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp1=new int[n];
         Arrays.fill(dp1,-1);
         int take0th=solve(nums,0,dp1,n-2);
         int[] dp2=new int[n];
         Arrays.fill(dp2,-1);
         int takefirst=solve(nums,1,dp2,n-1);
         return Math.max(take0th,takefirst);
    }
     public int solve(int[] nums, int i, int[] dp, int end) {
        if (i > end) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int steal = nums[i] + solve(nums, i + 2, dp, end);
        int skip = solve(nums, i+ 1, dp, end);
        return dp[i] = Math.max(steal, skip);
    }
}