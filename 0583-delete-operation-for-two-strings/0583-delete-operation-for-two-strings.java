class Solution {
    int[][]dp;
    int n;int m;
    public int minDistance(String word1, String word2) {
        n=word1.length();
        m=word2.length();
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(word1,word2,0,0);
        return (n-ans)+(m-ans);
    }
    public int solve(String text1,String text2,int i,int j){
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+solve(text1,text2,i+1,j+1);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
         return dp[i][j]=Math.max(solve(text1,text2,i+1,j),solve(text1,text2,i,j+1));
        }
    }
