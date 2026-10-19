class Solution {
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        dp=new int[pairs.length+1][pairs.length+1];
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        for(int i=0;i<pairs.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,-1,pairs);
    }
    public int solve(int i,int prev,int[][] pairs){
        if(i>=pairs.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int skip=solve(i+1,prev,pairs);
        int take=0;
        if(prev==-1 || pairs[prev][1]<pairs[i][0]){
            take=1+solve(i+1,i,pairs);
        }
        return dp[i][prev+1]=Math.max(take,skip);
    }
}