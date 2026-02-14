class Solution {
    private double[][] dp;
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        dp = new double[query_row+1][query_glass+1];
        for(double[] a:dp){
            Arrays.fill(a,-1);
        }

        return Math.min(1.0,solve( poured ,query_row ,query_glass ));
    }

    public double solve(int k , int i , int j ){

        if( i<0 || j<0 ||i<j) return 0.0;

        if(i == 0 &&  j==0) return k;

        if(dp[i][j]!=-1) return dp[i][j];

        double left =Math.max(0.0,(solve(k,(i-1),j-1)-1)/2.0);
        double right=Math.max(0.0,(solve(k,(i-1),j)-1)/2.0);

        return dp[i][j]=left+right;
    }
}

// T.c - > O(n^2)  S.c -> O(n^2)