class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        
        long tsum =0 ;
        int m = grid.length ;
        int n = grid[0].length ;

        int row[] = new int[m];
        int col[] = new int[n];
        //Total Sum of a matrix

        for(int i = 0; i < m ; i++){
            for(int j =0 ; j < n ; j++){

                row[i] += grid[i][j];
                col[j] +=grid[i][j];
                tsum += grid[i][j];
            }
        }

        // if(tsum % 2 !=0 ) return false;

        // if(doAble(row , tsum )) return true;
        // if(doAble(col, tsum )) return true;

        // row sum 
         long currSum =0 ;
        for(int i =0 ; i < m ; i++){
            for(int j =0 ; j < n ; j++){

                currSum += grid[i][j];
            }

            long diff = Math.abs((tsum - currSum) - currSum);

            if(diff == 0) return true;
        }
        // col sum 
         currSum =0 ;
        for(int i =0 ; i < n ; i++){
            
            for(int j =0 ; j < m; j++){

                currSum += grid[j][i];
            }

            long diff = Math.abs((tsum - currSum) - currSum);

            if(diff == 0) return true;
        }

        return false;
    }

    public boolean doAble(int nums[] , int tsum){

        int left = nums[0];
        int right = tsum - left;

        for(int i = 1 ; i < nums.length;  i++){

            if(left == right) return true; 

            else if ( left > right ) return false;

            left += nums[i];
            right -= nums[i];
        }
        return false;
    }
}


//T.C -> O(m*n)
//S.C -> O(m*n)
