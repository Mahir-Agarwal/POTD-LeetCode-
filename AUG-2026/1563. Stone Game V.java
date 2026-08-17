class Solution {
    int[][] dp;

    public int stoneGameV(int[] stoneValues) {

        int n = stoneValues.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValues[i];
        }

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, n - 1, prefix);
    }

    public int solve(int i, int j, int[] prefix) {

        if (i == j) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;

        for (int k = i; k < j; k++) {

            // i .... k
            int left = prefix[k + 1] - prefix[i];

            // k+1 .... j
            int right = prefix[j + 1] - prefix[k + 1];

            if (left < right) {

                res = Math.max(
                    res,
                    left + solve(i, k, prefix)
                );

            } else if (right < left) {

                res = Math.max(
                    res,
                    right + solve(k + 1, j, prefix)
                );

            } else {

                res = Math.max(
                    res,
                    left + Math.max(
                        solve(i, k, prefix),
                        solve(k + 1, j, prefix)
                    )
                );
            }
        }

        return dp[i][j] = res;
    }
}