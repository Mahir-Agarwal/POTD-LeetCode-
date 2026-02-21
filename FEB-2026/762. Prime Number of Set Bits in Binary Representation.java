class Solution {
    public int countPrimeSetBits(int left, int right) {
        

        int count =0 ;

        for(int i  = left ;i <=  right; i++){

            int bit = Integer.bitCount(i);

            if(isPrime(bit)){
                count++;
            }
        }

        return count ;

    }

    public boolean isPrime(int n ){


        if( n <= 1) return false;
        for(int i = 2  ; i*i<=n ; i++){
            if(n%i ==0) return false; 
        }

        return true;
    }
}

//T.C ->  O(N*sqrt(M)) 
//S.C -> O(1)