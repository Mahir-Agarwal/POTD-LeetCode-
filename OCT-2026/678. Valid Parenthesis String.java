class Solution {
    public boolean checkValidString(String s) {
        
        // int open = 0 ; // '(' -> open++ ; 
        // int close = 0 ; // ')' -> close-- ;

        // for(int i = 0 ; i < s.length() ; i++){

        //     char ch = s.charAt(i);

        //     if(ch == '('){
        //         open++;
        //         close++;
        //     }    
        //     if (ch == ')'){
        //         open--;
        //         close--;
                
        //         if(open < 0 ) return false;
        //         close =Math.max(close, 0);
        //     }
        //     if(ch == '*'){
        //         open++;
        //         close--;
        //         close = Math.max(close , 0 );
        //     }            
        // }


        // return close == 0 ;


        int open = 0 ;
        int close = 0;
        int star =0 ;
        
        int n = s.length();

        for(int i = 0 ; i <n ;i++){
            char ch = s.charAt(i);
            if(ch == '(') {
                open++;
                close++;
            }    
            else if(ch == ')'){
                open--;
                close--;

                if(open < 0 ) return false;
                close =Math.max(close , 0 );
            }
            else if (ch == '*'){
                open++;
                close--;

                close =Math.max(close , 0 );
            }
        }

        return close == 0 ;



    }
}
