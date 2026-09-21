class Solution {
    public int numIslands(char[][] grid) {
       int m=grid.length;
        int n=grid[0].length;
        int island=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    island++;
                }
            }
        }
        return island;
    }
    public void dfs(int i,int j,char[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1'){
            return;
        }
        grid[i][j]='$';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}