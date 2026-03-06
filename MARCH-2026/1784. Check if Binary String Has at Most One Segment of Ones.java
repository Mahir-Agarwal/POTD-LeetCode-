class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length()==1 && s.charAt(0)=='1') return true;  
        
        int count =1 ; 
        for(int i =1 ; i < s.length() ; i++){

            if( s.charAt(i) != s.charAt(i-1) && s.charAt(i)=='1' ){
                count++;
            } 
        }


        return count == 1 ? true : false;
    }
}

//T.C: O(n) where n is the length of the string
//S.C: O(1) 