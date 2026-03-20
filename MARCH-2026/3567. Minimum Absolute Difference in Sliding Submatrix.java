class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        
        int  m = grid.length ;
        int  n = grid[0].length ;

        int new_row = (m - k + 1);
        int new_col = (n - k + 1);

        int res[][]  = new int [new_row][new_col];

        for(int i = 0; i < m-k+1 ; i ++){
            for(int j = 0  ; j < n-k+1  ; j++){

                int curr[]= new int[k*k];
                int idx =0 ;

                for(int row = i ; row < i+k ; row++){
                    for(int  col =j ; col < j+k ; col++){
                        curr[idx++] = grid[row][col];
                    }
                }
                
                Arrays.sort(curr);
                int min = Integer.MAX_VALUE;

                for(int l = 1 ;  l < curr.length ; l++){
                    
                    if(curr[l] != curr[l-1]) min = Math.min(min, Math.abs(curr[l-1] - curr[l]) );
                }

                if(min == Integer.MAX_VALUE) min = 0 ;

                res[i][j] = min ;


            }
        }

        return res;
    }
}
