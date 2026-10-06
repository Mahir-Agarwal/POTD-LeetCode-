class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        int close=0 ;

        for(char ch : s.toCharArray()){

            if(ch == '(')stack.push('(');
            else {

                if(stack.isEmpty()) close++;
                else stack.pop();
            }
        }

       
        return close + stack.size();
    }
}