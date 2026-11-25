class Solution {
    public boolean checkString(String s) {
       Stack<Character> stack=new Stack<>();
       for(int i=0;i<s.length();i++){
        if(stack.isEmpty()){
            stack.push(s.charAt(i));
        }
        if(s.charAt(i)=='a' && stack.peek()=='a'){
            stack.push('a');
        }
        if(s.charAt(i)=='b' && stack.peek()=='a'){
            stack.push('b');
        }
        if(s.charAt(i)=='a' && stack.peek()=='b'){
            return false;
        }
        }
        return true;
    }
}