class Solution {
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()+1];
        return solve(0,s,wordDict);
    }
      public boolean solve(int i, String s, List<String> wordDict) {
        if (i == s.length()) {
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        boolean ans=false;
        for (int j = i+1; j <= s.length(); j++) {
            String sub = s.substring(i, j);

            if (wordDict.contains(sub) && solve(j,s,wordDict)) {
                ans= true;
            }
        }
        dp[i]=ans;
        return ans;
}
}