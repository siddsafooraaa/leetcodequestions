class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i=i+k){
             String group = s.substring(i, Math.min(i + k, s.length()));
                int sum =sum(group);
                sb.append(sum);
            }
            s =sb.toString();
        }
        return s;
    } 
    public int sum(String s){
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum=sum+s.charAt(i)-'0';
        }
        return sum;
    }
}