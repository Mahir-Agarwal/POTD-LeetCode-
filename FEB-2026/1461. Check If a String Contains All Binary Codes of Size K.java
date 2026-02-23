class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        

       Set<String> set = new HashSet<>();

        int i = 0;
        int j = 0 ;

         while( j< s.length()){

            
            while( (j-i+1) > k ){
                 i++;
            }

            if( (j-i +1) == k) set.add(s.substring(i,j+1));

            j++;
         }  

        int max = (int) Math.pow(2,k);
        if( set.size() != max) return false;
        return true;
    }
}

//T.C ->  O(n)
//Sc -> O(n) 