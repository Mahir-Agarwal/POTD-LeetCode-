import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
    
   
    public static String removeDuplicateLetters(String s) {
        
        Set<Character> set =  new HashSet<>();

        int last[] =  new int [26];

        for(int i =0 ; i <s.length() ; i++){
            last[s.charAt(i)-'a'] = i;
        }

        Stack<Character> stack =  new Stack<>();

        for(int i = 0 ; i <s.length() ; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)) continue;

            while(!stack.isEmpty() &&  ((ch < stack.peek()) && (i<last[stack.peek()-'a']) ) ){
                
                set.remove(stack.pop());
            }

            stack.push(ch);
            set.add(ch);
        }

        StringBuilder res= new StringBuilder();

        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();

    }
    public static void main(String[] args) {
        
        String s = "cbacdcbc";
        String result = removeDuplicateLetters(s);
        System.out.println(result); // Output: "acdb"
    }
}
