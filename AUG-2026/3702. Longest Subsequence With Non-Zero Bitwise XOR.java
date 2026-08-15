class Solution {
    public int longestSubsequence(int[] nums) {
        
        int res = 0;

        for(int x : nums){
            res ^= x ;
        }

        if(res != 0 ) return nums.length ;

        for(int x : nums){

            int curr =res ^ x;

            if(curr != 0) return nums.length-1;
        }

        return 0 ;

    }
}
