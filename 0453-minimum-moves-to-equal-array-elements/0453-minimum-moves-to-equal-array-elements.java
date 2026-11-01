class Solution {
    public int minMoves(int[] nums) {
int min = nums[0];
for (int j = 1; j < nums.length; j++) {
    if (nums[j] < min) {
        min= nums[j];
    }
}
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int diff=Math.abs(min-nums[i]);
            sum=sum+diff;
        }
        return sum;
    }
}

