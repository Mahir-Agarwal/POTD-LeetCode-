class Solution {
    public long sumAndMultiply(int n) {
        
        long res = 0;
        long sum = 0 ;

        String s = n + "";
        for(char ch : s.toCharArray()){
            
            int curr = ch- '0' ;

            if(curr != 0 ){
                res = (res*10) + curr;
                sum +=curr;
            } 

            
        }


        return res * sum ;

    }
}