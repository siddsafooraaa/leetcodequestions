class Solution {
    int m;
    int n;
    int[][] dp;
    public int numDistinct(String s, String t) {
        m=s.length();
        n=t.length();
        dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,s,t);
    }
    public int solve(int i,int j,String s,String t){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
         return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)!=t.charAt(j)){
            return solve(i+1,j,s,t);
        }else{
            return dp[i][j]=solve(i+1,j,s,t)+solve(i+1,j+1,s,t);
        }
    }
}