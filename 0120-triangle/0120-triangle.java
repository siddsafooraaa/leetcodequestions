class Solution {
    int n;
    int dp[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        n=triangle.size();
        dp=new int[201][201];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
       return solve(triangle,0,0);
    }
    public int solve(List<List<Integer>> triangle,int i,int j){
      if(i==n-1){
        return triangle.get(i).get(j);
      }
      if(dp[i][j]!=Integer.MAX_VALUE){
        return dp[i][j];
      }
      int min=triangle.get(i).get(j)+Math.min(solve(triangle,i+1,j+1),solve(triangle,i+1,j));
      return dp[i][j]=min;
    }
}