class Solution {
    public int numberOfSubstrings(String s) {
        

        int a = 0 ;
        int b = 0 ;
        int c = 0 ; 

        int res =0 ;
        int j = 0 ;
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;

            while(a> 0 && b > 0  && c > 0 ){
                res += s.length() - i;; 
                char cj = s.charAt(j);
                if(cj == 'a') a--;
                else if (cj == 'b') b--;
                else c--;
                j++;
            }

        }

        return res ;
         


    }
}

//  abcabc