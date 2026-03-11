class Solution {
    public int bitwiseComplement(int n) {
        
        String str = Integer.toBinaryString(n);
        StringBuilder s = new StringBuilder(str);  
        for(int i =0 ; i < s.length() ; i ++){
            if(s.charAt(i) =='1'){
                s.setCharAt(i,'0');
            }else{
                s.setCharAt(i,'1');
            }
        }

        return Integer.parseInt(s.toString(),2);
    }
}

//T.C -> O(log n) where n is the given number, because we are converting the number to binary and iterating through its digits. The number of digits in the binary representation of n is proportional to log2(n).
//S.C -> O(log n) for the same reason as above, we are storing the