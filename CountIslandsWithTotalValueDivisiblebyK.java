class CountIslandsWithTotalValueDivisiblebyK {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = dfs(grid, i, j);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    long dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return 0;
        }

        int val = grid[i][j];
        grid[i][j] = 0;

        long sum = val;

        sum += dfs(grid, i + 1, j);
        sum += dfs(grid, i - 1, j);
        sum += dfs(grid, i, j + 1);
        sum += dfs(grid, i, j - 1);

        return sum;
    }
    public static void main(String[] args) {
        CountIslandsWithTotalValueDivisiblebyK solution = new CountIslandsWithTotalValueDivisiblebyK();
        int[][] grid = {
            {1, 2, 0, 0, 3},
            {4, 0, 0, 5, 6},
            {0, 0, 7, 8, 0},
            {9, 10, 0, 0, 11}
        };
        int k = 5;
        int result = solution.countIslands(grid, k);
        System.out.println("Number of islands with total value divisible by " + k + ": " + result);
    }
}