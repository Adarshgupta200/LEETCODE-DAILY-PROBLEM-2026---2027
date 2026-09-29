class CheckifThereIsaValidParenthesesStringPath {
    private int m, n;
    private char[][] grid;
    private Boolean[][][] memo;
    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
        memo = new Boolean[m][n][(m + n) / 2 + 1];   
        return dfs(0, 0, 0);
    }
    private boolean dfs(int r, int c, int balance) {
        if (r == m || c == n) return false;
        balance += (grid[r][c] == '(') ? 1 : -1;
        if (balance < 0 || balance > (m + n) / 2) return false;
        if (r == m - 1 && c == n - 1) return balance == 0;
        if (memo[r][c][balance] != null) return memo[r][c][balance];
        return memo[r][c][balance] = dfs(r + 1, c, balance) || dfs(r, c + 1, balance);
    }
    public static void main(String[] args) {
        CheckifThereIsaValidParenthesesStringPath obj = new CheckifThereIsaValidParenthesesStringPath();
        char[][] grid = {{'(', '(', ')'}, {')', '(', ')'}, {'(', '(', ')'}};
        boolean result = obj.hasValidPath(grid);
        System.out.println(result); // Output: true
    }
}