class MinimumXORPathinaGrid {
    boolean[][][] memo;
    boolean[] possible;
    
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        memo = new boolean[m][n][1024]; 
        possible = new boolean[1024];
        
        solve(0, 0, grid[0][0], grid, m, n);
        
        for (int i = 0; i < 1024; i++) {
            if (possible[i]) {
                return i;
            }
        }
        return 0;
    }
    
    private void solve(int r, int c, int val, int[][] grid, int m, int n) {
        if (r == m - 1 && c == n - 1) {
            possible[val] = true;
            return;
        }
        
        if (memo[r][c][val]) {
            return;
        }
        
        memo[r][c][val] = true;
        
        if (r + 1 < m) {
            solve(r + 1, c, val ^ grid[r + 1][c], grid, m, n);
        }
        
        if (c + 1 < n) {
            solve(r, c + 1, val ^ grid[r][c + 1], grid, m, n);
        }
    }
    public static void main(String[] args) {
        MinimumXORPathinaGrid solution = new MinimumXORPathinaGrid();
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int result = solution.minCost(grid);
        System.out.println("Minimum XOR Path Cost: " + result);
    }
}