public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
            int res =0;
            for(int  i =0 ; i<32 ; i++){
               res = res<<1; // make space first 
               res  |= (n&1);// take last bit of n
               n>>=1; //unsigned right;
             
            }

            return res;
    }
}

// T.C -> O(1)  S.C -> O(1)
