class Solution {
    int n;
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        n=triangle.size();
        dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return solve(0,0,triangle);
    }
    public int solve(int i,int j,List<List<Integer>> triangle){
        if(i==n-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        return dp[i][j]=triangle.get(i).get(j)+Math.min(solve(i+1,j,triangle),solve(i+1,j+1,triangle));
    }
}