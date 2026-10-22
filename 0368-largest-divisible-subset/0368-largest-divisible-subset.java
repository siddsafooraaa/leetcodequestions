class Solution {
    int[][] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        solve(0, -1, nums);
        List<Integer> result = new ArrayList<>();
        int prev = -1;

        for (int i = 0; i < n; i++) {
            int skip = solve(i + 1, prev, nums);
            int take = 0;
            if (prev == -1 || nums[i] % nums[prev] == 0) {
                take = 1 + solve(i + 1, i, nums);
            }
            if (take > 0 && take >= skip &&
                (prev == -1 || nums[i] % nums[prev] == 0)) {
                result.add(nums[i]);
                prev = i;
            }
        }
        return result;
    }
    public int solve(int i, int prev, int[] nums) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        int skip = solve(i + 1, prev, nums);
        int take = 0;
        if (prev == -1 || nums[i] % nums[prev] == 0) {
            take = 1 + solve(i + 1, i, nums);
        }
        return dp[i][prev + 1] = Math.max(take, skip);
    }
}
