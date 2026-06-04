class Solution {
    public int totalWaviness(int num1, int num2) {
        
        if(  num2 < 100 ) return 0 ; 

        int totalwaviness =0 ;

        for( int i =  num1 ; i <= num2 ; i++ ){

            totalwaviness += solve(i);
        }

        return totalwaviness;

    }
    public int solve(int ele ){
        String s = ele + "";
        int count =0 ; 
        for(int i = 1 ; i < s.length()-1 ; i++){
            
            if(s.charAt(i) > s.charAt(i-1) && s.charAt(i) > s.charAt(i+1) ||
               s.charAt(i)  < s.charAt(i-1) && s.charAt(i) <  s.charAt(i+1)
             )  count++;

        }
        return count ;
    }
}
//                 9899
//                 9999
// //  1 ------ 1     0000    0 

// 121  , 122  
// 1211 , 