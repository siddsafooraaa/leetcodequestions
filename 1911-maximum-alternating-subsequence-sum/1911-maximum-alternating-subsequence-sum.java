class Solution {
    int n;
    long[][] dp = new long[100001][2];
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, nums, true);
    }
    long solve(int idx, int[] nums, boolean flag) {
        if (idx >= n) {
            return 0;
        }
        int f = flag ? 1 : 0;
        if (dp[idx][f] != -1) {
            return dp[idx][f];
        }
        long skip = solve(idx + 1, nums, flag);
        long val = nums[idx];
        if (flag == false) {
            val = -val;
        }
        long take = solve(idx + 1, nums, !flag) + val;
        return dp[idx][f] = Math.max(skip, take);
    }
}