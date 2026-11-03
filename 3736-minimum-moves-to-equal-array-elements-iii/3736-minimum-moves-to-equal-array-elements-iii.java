class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
              max=nums[i];
            }
        }
        int sum=0;
        for(int j=0;j<nums.length;j++){
            int diff=max-nums[j];
            sum+=diff;
        }
        return sum;
    }
}