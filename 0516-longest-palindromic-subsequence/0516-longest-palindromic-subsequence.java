class Solution {
    int n;
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        n=s.length();
        dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,n-1,s);
    }
    public int solve(int i,int j,String s){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return 2+solve(i+1,j-1,s);
        }
        
        return dp[i][j]=Math.max(solve(i+1,j,s),solve(i,j-1,s));
    }
}