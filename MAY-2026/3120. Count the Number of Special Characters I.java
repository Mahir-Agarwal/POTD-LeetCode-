class Solution {
    public int numberOfSpecialChars(String word) {
        
        boolean low [] = new boolean [26];

        boolean high[] = new boolean [26];


        for(int i =0  ;i < word.length() ;i++){

            char ch= word.charAt(i);

            if(ch>='a' && ch <= 'z') low[ch-'a'] = true; 
            else if(ch>='A' && ch <= 'Z') high[ch-'A'] = true;
        }

        int count =0 ;

        for(int i =0 ; i< 26 ;i++){
            
            if(low[i] && high[i]) count++;
        }

        return count ;
    }
}

//T.C -> O(n)