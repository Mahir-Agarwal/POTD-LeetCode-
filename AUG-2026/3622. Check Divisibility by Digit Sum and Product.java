class Solution {
    public boolean checkDivisibility(int n) {
        
        if( n < 9 ) return false; 
        int sum = 0 ;
        int product = 1 ;
        
        int l = n  ; 

        while( l > 0  ){

            int curr = l % 10;

            sum += curr;
            product *= curr;

             l /=10;
        }
        sum += product ;

        return   n % sum  == 0 ? true : false ;

    }
}
