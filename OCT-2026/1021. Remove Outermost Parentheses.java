class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder str = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < s.length() ; i++){
            
            char ch  = s.charAt(i);

            if(ch == '(') stack.push(i);
            else{

                int idx = stack.pop();
                if(stack.isEmpty()){
                    set.add(idx);
                    set.add(i);
                } 

            }
        }

         for(int i = 0 ; i < s.length() ; i++){
            
            char ch  = s.charAt(i);
            if(!set.contains(i)) str.append(ch);
        }

        return str.toString();
    }
}

// "(()())(())"

