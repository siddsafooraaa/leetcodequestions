class Solution {
    int m;
    int n;
    long[][] maxDp;
    long[][] minDp;
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
         maxDp = new long[m][n];
        minDp = new long[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(maxDp[i], Long.MIN_VALUE);
            Arrays.fill(minDp[i], Long.MIN_VALUE);
        }

        long[] ans = solve(0, 0, grid);
        long maxProd = ans[0];
        if(maxProd < 0) {
            return -1;
        }
        return (int)(maxProd % 1000000007);
    }
    public long[] solve(int i,int j,int[][] grid){
        if(i==m-1 && j==n-1){
            return new long[]{grid[i][j],grid[i][j]};
        }
        if(maxDp[i][j] != Long.MIN_VALUE){
            return new long[]{maxDp[i][j], minDp[i][j]};
        }
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        if(i+1<m){
            long[] down=solve(i+1,j,grid);
            long downMax = down[0];
            long downMin = down[1];
            max=Math.max(max,Math.max((long) grid[i][j]*downMax,(long) grid[i][j]*downMin));
            min = Math.min(min,Math.min((long)grid[i][j] * downMax,(long)grid[i][j] * downMin));
        }
         if(j+1<n){
            long[] right=solve(i,j+1,grid);
            long rightMax = right[0];
            long rightMin = right[1];
            max=Math.max(max,Math.max((long) grid[i][j]*rightMax,(long) grid[i][j]*rightMin));
            min = Math.min(min,Math.min((long)grid[i][j] * rightMax,(long)grid[i][j] * rightMin));
        }
        maxDp[i][j] = max;
        minDp[i][j] = min;

         return new long[]{max, min};
    }
}