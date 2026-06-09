class Solution {
    public long maxTotalValue(int[] nums, int k) {
        
        long res= 0 ; 
        
        long maxDiff = 0 ; 

        long max = 0;
        long min= Long.MAX_VALUE;

        for(int x : nums){
            max = Math.max(max , x );
            min =Math.min(min , x );
        }

        maxDiff = max-min;

        res += maxDiff * k ;

        return res; 
    }
}

