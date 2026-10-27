class Solution {
    int m;
    int n;
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m=dungeon.length;
        n=dungeon[0].length;
        dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,dungeon);
    }
    public int solve(int i,int j,int[][] dungeon){ 
        if(i==m-1 && j==n-1){
            return Math.max(1,1-dungeon[i][j]);
        }
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=solve(i+1,j,dungeon);
        int right=solve(i,j+1,dungeon);
        int need=Math.min(right,down);
        return dp[i][j]=Math.max(1,need-dungeon[i][j]);
    }
}