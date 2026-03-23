class Solution {
    public int directions[][] = {
        {1,0},{0,1}
    };
    public Set<Long> set; 
    
    public int maxProductPath(int[][] grid) {
        
        set = new HashSet<>();
        
        dfs( 0, 0,  1 , grid ) ;

        long max = -1;

        for(long ele : set){ // (O (size of set))
            max =Math.max(max , ele);
        }

        if (max <0 ) return -1;

        long mod = (long) (1e9+7) ;

        return (int) ( max % mod ) ;
    }

    public void dfs(int i ,int j, long product , int grid[][]){

        if( grid [i][j] ==0 ) {
            set.add((long)0);
            return ;
        }

        if(i == grid.length-1 && j == grid[0].length-1) {
            product*= grid[i][j];
            set.add(product);
        }

        product *= grid[i][j];

        for(int dir[] : directions){
            int ni = dir[0]+i;
            int nj = dir[1]+j;

            if( ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length ) dfs(ni,nj,product,grid);
        }
    }
}

 // T.C -> O(2^(n+m))
 //S.C -> O(2^(n+m))