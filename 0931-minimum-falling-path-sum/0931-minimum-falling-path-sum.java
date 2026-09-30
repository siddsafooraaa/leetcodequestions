class Solution {
    int row, col;
    int[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            ans = Math.min(ans, solve(matrix, 0, j));
        }
        return ans;
    }

    private int solve(int[][] matrix, int i, int j) {
        if (j < 0 || j >= col) {
            return 1_000_000_000; 
        }
        if (i == row - 1) {
            return matrix[i][j];
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        int left  = solve(matrix, i + 1, j - 1);
        int below = solve(matrix, i + 1, j);
        int right = solve(matrix, i + 1, j + 1);
        return dp[i][j] = matrix[i][j] + Math.min(left, Math.min(below, right));
    }
}