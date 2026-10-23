class Solution {
    public int maxAscendingSum(int[] nums) {
        int left=0;
        int right=1;
        int maxSum=nums[0];
        int sum=nums[left];
        while(right<nums.length){
            if(nums[right]>nums[left]){
            sum=sum+nums[right];
            right++;
            left++;
        }else{
            sum=nums[right];
            right++;
            left++;
        }
        if(sum>maxSum){
            maxSum=sum;
        }
    }
    return maxSum;
}
}