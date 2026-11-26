class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.offer(new int[]{i,j});
                }else{
                    ans[i][j]=-1;
                }
            }
        }
        int[][] directions={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
        };
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    ans[nr][nc] == -1) {
                    ans[nr][nc] = ans[r][c] + 1;
                    q.offer(new int[]{nr, nc});
        }
    }
}
return ans;
    }
}