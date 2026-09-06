class Solution {
    public int dp[][];
    public int numDistinct(String s, String t) {
        
        dp = new int [s.length()][t.length()];

        for(int d [] : dp ){
            Arrays.fill(d, -1 );
        }

        return solve( 0, 0  , s , t ); 
    }

    // public int solve(int i , int j  ,String s , String t ){

    //     if ( j ==  t. length()) return 1 ;
    //     if ( i  == s.length()) return 0 ;


    //     // for(int idx = i ; idx < s.length() ; idx++){

    //     // }
    //     if( dp[i][j] != -1 ) return dp[i][j];
    //     if( s.charAt(i) == t.charAt( j )){
    //         return dp[i][j] = solve(i+1, j+1  ,   s , t )  + solve( i+1 , j , s , t );
    //     }

    //     return  dp[i] [j] = solve(i+1, j  , s , t ) ;

    // }

    public int solve(int i , int j , String s , String t ){
        
        
        if( j == t.length() ) return 1 ;

        if( i == s.length() ) return 0 ;

        if(dp[i][j] != -1) return dp[i][j];
        int take = 0 ;

        if(s.charAt(i) == t.charAt(j)) take = (solve(i+1, j+1 , s , t) ) ;

        int nottake = solve(i+1, j , s, t ) ;

        return  dp[i][j] = take + nottake;
    }
}