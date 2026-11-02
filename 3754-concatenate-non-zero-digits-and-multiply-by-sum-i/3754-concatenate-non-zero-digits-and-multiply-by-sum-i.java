class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb=new StringBuilder();
        int sum=0;
        while(n>0){
            int rem=n%10;
            if(rem!=0){
                sum+=rem;
               sb.append(rem);
            }
            n=n/10;
        }
        sb.reverse();
         long num = sb.length() == 0 ? 0 : Long.parseLong(sb.toString());
         long ans=sum*num;
         return ans;
    }
}