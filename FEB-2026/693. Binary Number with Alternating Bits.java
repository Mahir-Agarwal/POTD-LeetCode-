class Solution {
    public boolean hasAlternatingBits(int n) {
        
        // int bit[] = new int [33];
        //  for(int i =0 ; i <32 ;i++){
            
        //     bit[i] = n & (1<<i);

        // }   
        
        // for(int i = 1 ; i<=32 ;i++){
        //     if( bit[i]==1 && bit[i]==bit[i-1] ) return false;
        // }

        String res = Integer.toBinaryString(n);

        for(int i =1 ; i<res.length();i++){

            if(res.charAt(i)==res.charAt(i-1)) return false;
        }

        return true;

        
    }
}

//T.C -> O(1)  S.C -> O(1)