class Solution {
    public int mirrorDistance(int n) {
        int nn = n ;
        int rev = 0;

        while ( n > 0 ){

            int curr = n% 10 ;
            rev = rev*10 + curr;
            n/=10;
        }

        return Math.abs(nn - rev );
    }
}