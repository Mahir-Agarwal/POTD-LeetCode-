class Solution {
    public int directions[][] = {
            { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }
    };
    public boolean visited[][];

    public boolean containsCycle(char[][] grid) {

        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (!visited[i][j] && solve(i, j, new int[] { -1, -1 }, grid))
                    return true;
                ;
            }
        }

        return false;

    }

    public boolean solve(int i, int j, int parent[], char[][] grid) {

        visited[i][j] = true;

        for (int dir[] : directions) {

            int ni = dir[0] + i;
            int nj = dir[1] + j;

            if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length) {
                if (grid[i][j] != grid[ni][nj])
                    continue;

                if (visited[ni][nj]) {
                    if (ni != parent[0] || nj != parent[1]) {
                        return true;
                    }
                }
                if (!visited[ni][nj]) {
                    if (solve(ni, nj, new int[] { i, j }, grid))
                        return true;
                }
            }
        }

        return false;

    }
}