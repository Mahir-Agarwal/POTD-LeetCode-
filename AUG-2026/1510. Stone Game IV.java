class Solution {
    public Boolean dp [];
    public boolean winnerSquareGame(int n) {
        
        dp= new Boolean[n+1];

        return solve( n ) ;
    }

    public boolean solve(int n  ){

        if(n <= 0 ) return false;

        if(dp[n] !=null) return dp[n];
        for(int i = 1 ; i*i <=n ; i++){

            if(solve( n - (i*i) )  == false) return dp[n] =  true; 
            
        }

        return dp[n] = false ; 
    }
}

