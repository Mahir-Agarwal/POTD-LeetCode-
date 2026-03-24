class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        
        int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
        
        int [][]right = new int [n][m];

        long suffix = 1 ;
        for(int i = n-1 ; i >=0 ; i--){
            for(int j = m-1 ; j>=0 ; j--){
               
               right [i][j] = (int) suffix;
               suffix = (suffix * grid[i][j]) % MOD;
              
            }
        }
        long prefix = 1; 
        for(int i =0 ; i< n ; i++){
            for(int j =0 ; j< m ;j++){
                
                int ele = grid[i][j];
                right [i][j] = (right[i][j] * (int) prefix)% MOD;
                prefix = ( prefix* ele ) % MOD;
            }
        }

        return right;
        
    }
}
//T.C - > O(n*m)
//S.C - > O(n*m)