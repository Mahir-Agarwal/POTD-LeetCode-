class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int i = n ; i<=100 ; i++ ){

            int digit = i ;
            int product = 1 ;

            while ( digit >0 ){
                
                product *= (digit % 10);
                digit/=10;
            }

            if( (product % t) == 0 ) return i ; 
        }

        return -1 ;
    }
}