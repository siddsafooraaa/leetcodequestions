class Solution {
    int n;
    int m;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        n=word1.length();
        m=word2.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,word1,word2);
    }
    public int solve(int i,int j,String s,String e){
        if(i==s.length()){
            return e.length()-j;
        }
        if(j==e.length()){
            return s.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==e.charAt(j)){
            return solve(i+1,j+1,s,e);
        }
        return dp[i][j]=1+Math.min(solve(i+1,j,s,e),solve(i,j+1,s,e));
    }
}