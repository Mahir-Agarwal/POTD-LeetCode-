class Solution {
   
    public int dp[][] ;
    public boolean predictTheWinner(int[] nums) {
        
        dp = new int [nums.length][nums.length];

        for(int x[] : dp) Arrays.fill( x , -1);

        return  solve( 0, nums.length-1 ,  nums  ) >=0 ? true : false; 
    }

    public int solve(int i , int j , int nums[] ){


        if( i > j  ) return 0 ; 

        if(dp[i][j] != -1) return dp[i][j];

        int take = nums[i]  - solve( i+1 ,j , nums );
        int ntake = nums[j]  - solve( i  ,j-1 , nums );
       

        return dp[i][j] = Math.max(take, ntake );
        
    }
}
