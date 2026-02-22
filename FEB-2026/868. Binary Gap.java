class Solution {
    public int binaryGap(int n) {
        

        String s = Integer.toBinaryString(n);

    
        int idx= -1;
        int max= 0 ;

        // for(int i =0 ; i < s.length() ;i++){
        //     char ch = s.charAt(i);
        //     if(ch == '1' && flag == true){
        //         int diff = i - idx;
        //         max = Math.max(max , diff);
        //         idx = i ;

        //     }else if ( ch == '1' && flag  == false){
        //         flag = true;
        //         idx= i ;
        //     }
        // }
        int i =0 ;
        while (n>0){

            if( ((n&1) == 1) ){
                if( idx !=-1){
                int diff = i - idx;
                max  = Math.max(diff ,max);
                }
                idx = i; 
                
            }
             n = n>>1 ;
             i++;
        }
        return max ;
    }
}

//T.C -> O(logn) for traversing the binary string and O(1) for calculating the max so overall O(logn)
//S.C -> O(1) 