class Solution {
    public int minimumDeletions(String s) {
        

        int res =0 ;
        int b =0;

        for(int i =0 ; i < s.length();i++){
            char ch = s.charAt(i);
            if(ch =='b'){
                b++;
            }else if( b>0){
                res++;
                b--;
            }
        }

        return res;
    }
}

// using greedy approch 
//T.C -> O(n) 
// S.C -> O(1)