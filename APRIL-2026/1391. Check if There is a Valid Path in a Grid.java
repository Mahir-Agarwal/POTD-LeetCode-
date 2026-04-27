class Solution {
    public int directions[][] = {
            { 0, 1 }, { 1, 0 }, { -1, 1 },
            { 1, 1 }, { -1, -1 }, { 1, -1 }
    };
    public HashMap<Integer, List<int[]>> map;

    public boolean hasValidPath(int[][] grid) {

        map = new HashMap<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        mapbuild();
        return solve(0, 0, grid, visited);
    }

    public void mapbuild() {
        for (int i = 1; i <= 6; i++) {
            map.put(i, new ArrayList<>());
        }
        map.get(1).add(new int[] { 0, 1 });
        map.get(1).add(new int[] { 0, -1 });
        map.get(2).add(new int[] { -1, 0 });
        map.get(2).add(new int[] { 1, 0 });
        map.get(3).add(new int[] { 0, -1 });
        map.get(3).add(new int[] { 1, 0 });
        map.get(4).add(new int[] { 0, 1 });
        map.get(4).add(new int[] { 1, 0 });
        map.get(5).add(new int[] { 0, -1 });
        map.get(5).add(new int[] { -1, 0 });
        map.get(6).add(new int[] { -1, 0 });
        map.get(6).add(new int[] { 0, 1 });
    }

    public boolean solve(int i, int j, int grid[][], boolean visited[][]) {

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return true;
        // if( i == grid.length-1 || j== grid[0].length-1) return false;

        visited[i][j] = true;
        if (map.get(grid[i][j]) != null) {
            for (int[] v : map.get(grid[i][j])) {
                int ni = i+v[0];
                int nj = j+v[1];
                boolean flag = false;
                
                if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && !visited[ni][nj] ) {
                    for (int[] back : map.get(grid[ni][nj])) {
                        int backi = back[0];
                        int backj = back[1];
                        if (backi == -v[0] && backj == -v[1])
                            flag = true;
                    }
                    if (flag == true && solve(ni, nj, grid, visited))
                        return true;
                }

            }
        }

        return false;

    }
}