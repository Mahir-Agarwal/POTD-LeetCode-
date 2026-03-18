class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        
        int res =0 ;
        int prev[][] = new int[grid.length][grid[0].length];
        
        for(int i= 0 ; i < grid.length ; i ++){
            for(int j = 0 ;  j < grid[0].length ; j++){
                
                
                
                prev[i][j] = grid[i][j];


                if(  i > 0 ) prev[i][j] += prev[i-1][j];
                if(  j > 0 ) prev[i][j] += prev[i][j-1];
                if(  i > 0 && j > 0 ) prev[i][j] -= prev[i-1][j-1];

                if(prev[i][j] <=k) res++;
                else break ;
            }
        }

        return res;
    }
}
//T.C -> O(n^2);
//S.C- > O(n^2); 