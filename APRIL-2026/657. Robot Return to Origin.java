class Solution {
    public boolean judgeCircle(String moves) {
        

        int l =0 ;
        int r =0 ;
        int u =0 ;
        int d =0 ;

        for(char ch : moves.toCharArray()){

            if ( ch == 'L') l++;
            if ( ch == 'U') u++;
            if ( ch == 'R') r++;
            if ( ch == 'D') d++;
        }

        return  ( l  == r &&  d == u );


    }
}