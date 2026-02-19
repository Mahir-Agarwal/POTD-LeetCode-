class Solution {
    public int countBinarySubstrings(String s) {
        
        int prev = 0;
        int curr= 1;
        int total =0;
        for(int i =1 ; i < s.length() ; i++){

            if(s.charAt(i)== s.charAt(i-1)){
                curr++;
            }else{
                total += Math.min(prev , curr);

                prev =curr;
                curr =1;
            }
        }

        total+=Math.min(prev,curr);

        return total;
    }
}

//T.C -> O(n) where n is the length of the string s
//S.C -> O(1) as we are using only constant space to store the variables