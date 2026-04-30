class Solution {
    public Integer dp[][][];
    public int maxPathScore(int[][] grid, int k) {


        if(grid[0][0] > 0 && k <=0 ) return -1;

        dp = new Integer [grid.length][grid[0].length][k+1];


        int ans = solve( 0, 0  , grid , k );

        return ans < 0 ? -1  : ans ; 
    }

    public int solve(int i ,int j ,int grid[][], int k ){

        if( i >=  grid.length  ||  j  >= grid[0].length  ) return -1 ;

        if(  grid[i][j] > 0 && k <= 0 ) return  dp[i][j][k]  = -1 ;

        if( dp[i][j][k] != null ) return dp[i][j][k] ; 

        if( i ==  grid.length-1 &&  j  == grid[0].length-1 ) {
            if (grid[i][j] > 0 && k <= 0) return -1;
            return dp[i][j][k] = grid[i][j];
        }

        int cost = 0;
        int newK = k ;

        if(grid[i][j] > 0 ){
            cost = grid[i][j];
            newK = k-1 ;
        }
        
        int down =  solve(i+1 , j , grid, newK);
        int right =  solve(i , j+1 , grid, newK);
        
        int max= Math.max(down , right);

        if(max == -1  ) return dp[i][j][k] = -1;

        return dp[i][j][k] = max + cost;

    }
}