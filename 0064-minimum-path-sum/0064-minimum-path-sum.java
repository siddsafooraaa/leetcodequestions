class Solution {
    int m;
    int n;
    int[][] dp;
    public int minPathSum(int[][] grid) {
         m=grid.length;
         n=grid[0].length;
         dp=new int[m][n];
         for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
         }
        return solve(grid,0,0);
    }
    public int solve(int[][] grid,int i,int j){
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==m-1){
            return grid[i][j]+solve(grid,i,j+1);
        }
        else if(j==n-1){
            return grid[i][j]+solve(grid,i+1,j);
        }else{
            int right=solve(grid,i,j+1);
            int down=solve(grid,i+1,j);
            return dp[i][j]=grid[i][j]+Math.min(right,down);
        }
    }
}