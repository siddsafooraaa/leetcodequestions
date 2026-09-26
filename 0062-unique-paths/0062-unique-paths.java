class Solution {
    int m;
    int n;
    int[][] dp;
    public int uniquePaths(int m, int n) {
        this.m=m;
        this.n=n;
         dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
            }
        return solve(0,0);
    }
    public int solve(int i,int j){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i<0 || i>=m || j<0 || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=solve(i,j+1);
        int down=solve(i+1,j);
        return dp[i][j]= right+down;
    }
}