class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0,nums,0,target);
    }
    public int solve(int i,int[] nums,int currSum,int target){
        if(i>=nums.length){
            if(currSum==target){
                return 1;
            }
            return 0;
        }
        int plus=solve(i+1,nums,currSum+nums[i],target);
        int minus=solve(i+1,nums,currSum-nums[i],target);
        return plus+minus;
    }
}