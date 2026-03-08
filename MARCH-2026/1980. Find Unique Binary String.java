class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder str =  new StringBuilder();
        
        for(int i=0;i<nums.length;i++){
            char ch  =  nums[i].charAt(i);
            if(ch=='0'){
                str.append('1');
            }else{
                str.append('0');
            }
        }
    
        return str.toString();
    }
}

//T.c: O(n) where n is the length of the input array
//S.C: O(n) where n is the length of the input array