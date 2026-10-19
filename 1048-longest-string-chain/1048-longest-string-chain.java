class Solution {
    int[][] dp;
    public int longestStrChain(String[] words) {
        dp=new int[words.length+1][words.length+1];
        Arrays.sort(words,(a,b)-> a.length()-b.length());
        for(int i=0;i<words.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return LIS(-1,0,words);
    }
    public int LIS(int prev,int i,String[] words){
        if(i>=words.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int skip=LIS(prev,i+1,words);
        int take=0;
        if(prev==-1 || check(words[prev],words[i])){
            take=1+LIS(i,i+1,words);
        }
        return dp[i][prev+1]=Math.max(take,skip);
    }
    public boolean check(String shorter,String longer){
        int i=0;
        int j=0;
        if(longer.length()-shorter.length()!=1){
            return false;
        }
        while(i<shorter.length() && j<longer.length()){
            if(shorter.charAt(i)==longer.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
            return i==shorter.length();
        }
    }
