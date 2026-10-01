class Solution {
    int m;
    int n;
    int dp[][][];
    public int cherryPickup(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[71][71][71];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            Arrays.fill(dp[i][j],-1);
        }
        }
        return solve(grid,0,0,n-1);
    }
    public int solve(int[][] grid,int row,int col1,int col2){
        if(row>=m){
            return 0;
        }
        if(dp[row][col1][col2]!=-1){
            return dp[row][col1][col2];
        }
        int cherry=grid[row][col1];
        if(col1!=col2){
            cherry+=grid[row][col2];
        }
        int ans=Integer.MIN_VALUE;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int newrow=row+1;
                int newcol1=col1+i;
                int newcol2=col2+j;
                if(newcol1>=0 && newcol1<n && newcol2>=0 && newcol2<n){
                ans=Math.max(ans,solve(grid,newrow,newcol1,newcol2));
            }
        }
        }
        return dp[row][col1][col2]=cherry+ans;
    }
}