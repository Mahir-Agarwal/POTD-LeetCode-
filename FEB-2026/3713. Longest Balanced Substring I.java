class Solution {
    public int longestBalanced(String s) {
        
       

        int max = 0;
        for(int i =0; i< s.length() ; i++){
            
            int map[] = new int [26];
            for(int j = i ; j < s.length() ;j++){
                char ch = s.charAt(j);
                map[ch-'a']+=1;
                int count = map[ch-'a'];
                
                if(doable(map)) max = Math.max(max,  j-i+1);
                
            }

           
        }

        return max;
    }

    public boolean doable(int map[]){
        int val = -1;

        for(int i : map){
            if( i!= 0 && val==-1 ) {
                val = i;
            }    
            else if ( (i!=0) && (i!=val) ) {
                return false;
            }    
        }

        return true;
    }
}
