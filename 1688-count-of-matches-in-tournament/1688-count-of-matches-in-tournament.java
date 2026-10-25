class Solution {
    public int numberOfMatches(int n) {
        int ans=0;
        int matches=0;
        while(n!=1){
        if(n%2!=0){
             matches =(n - 1)/2;
             n = (n -1)/2 + 1;
            ans=ans+matches;
        }
        if(n%2==0){
            matches=n/2;
            n=n/2;
            ans=ans+matches;
        }
    }
    return ans;
    }
}