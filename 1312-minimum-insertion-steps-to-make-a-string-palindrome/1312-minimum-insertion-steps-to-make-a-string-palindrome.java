class Solution {
    int n;
    int[][] dp;
    public int minInsertions(String s) {
        n=s.length();
        dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        String rev=new StringBuilder(s).reverse().toString();
        int ans=solve(0,0,s,rev);
        return n-ans;
    }
    public int solve(int i,int j,String s,String rev){
        if(i==s.length() || j==rev.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==rev.charAt(j)){
            return 1+solve(i+1,j+1,s,rev);
        }
        return dp[i][j]=Math.max(solve(i+1,j,s,rev),solve(i,j+1,s,rev));
    }
}