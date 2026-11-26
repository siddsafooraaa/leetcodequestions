class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            dfs(grid,i,0);
            dfs(grid,i,n-1);       //travel furst and last column while keeping the row as i
        }
         for(int j=0;j<n;j++){
            dfs(grid,0,j);
            dfs(grid,m-1,j);
        }
        int count=0;
        for(int i=0;i<m;i++){             // traversing the first and last row while keeping the         column                                       moving
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
   return count;
    }
    public void dfs(int[][] grid,int row,int col){
        int m=grid.length;
        int n=grid[0].length;
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]==0){
            return;
        }
        grid[row][col]=0;
        dfs(grid,row,col+1);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row-1,col);
    }
}