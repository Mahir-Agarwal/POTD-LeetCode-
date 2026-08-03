class Solution {
    public int dp[];
    public String stoneGameIII(int[] stoneValue) {
        
        dp = new int [stoneValue.length] ;
        Arrays.fill(dp, -1);
        int res =  solve( 0, stoneValue);

        if(res ==0) return "Tie";
        return res > 0 ? "Alice" : "Bob";
    }

    public int solve(int i, int [] nums){

        if( i >=nums.length ) return 0 ;

        if(dp[i] != -1 )return dp[i];
        int one = nums[i] - solve(i+1 , nums);
        int two = Integer.MIN_VALUE  ;
        if((i+1) < nums.length) two = nums[i]+nums[i+1] - solve(i+2 , nums);
        int three = Integer.MIN_VALUE ;
        if((i+2) < nums.length) three = nums[i]+nums[i+1]+nums[i+2] - solve(i+3 , nums);

        return dp[i]= Math.max(one , Math.max(two , three));

    }

}

T.C -> O(n)
S.C -> O(n)