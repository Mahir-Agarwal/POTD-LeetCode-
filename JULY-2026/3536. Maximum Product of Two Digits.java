class Solution {
    public int maxProduct(int n) {
        
        int max = 0 ;

        int ans = 0 ;

        while ( n > 0){

            int curr = n % 10 ; 

            ans = Math.max( ans , max * curr );

            max =Math.max(max , curr ); 
            n/= 10 ;


        }

        return ans ; 
    }
}