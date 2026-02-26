import java.math.BigInteger;

class Solution { // logic mera hai code likh liya tha but idk BigInteger so just convert kiya int to BigInteger and then apply the same logic and it worked :)
    public int numSteps(String s) {
        // BigInteger res = new BigInteger(s, 2); 
        // int c = 0;
        
      
        // while (!res.equals(BigInteger.ONE)) {
        //     if (res.mod(BigInteger.TWO).equals(BigInteger.ZERO)) { 
        //         res = res.divide(BigInteger.TWO); // Divide by 2
        //     } else {
        //         res = res.add(BigInteger.ONE); // Add 1
        //     }
        //     c++;
        // }
        // return c;

        //Approach -2 
        
        int step =0 ;
        int carry =0 ;

        for(int i = s.length()-1; i>0 ; i--){
            
            int bit = (s.charAt(i)-'0') + carry;

            if(bit ==1 ){
                step+=2;
                carry = 1 ;
            }else{
                step++;
            }
        }

        return step+carry ;
    }
}
