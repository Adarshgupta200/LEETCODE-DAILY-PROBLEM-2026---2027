public class MaximumMatrixSum {

    static class Solution {
        public long maxMatrixSum(int[][] matrix) {
            long ts = 0;
            int ncunt = 0;
            boolean found = false;
            int small = (int) 1e9;

            for (int[] row : matrix) {
                for (int num : row) {
                    if (num < 0) ncunt++;
                    if (num == 0) found = true;

                    int absnum = Math.abs(num);
                    ts += absnum;
                    small = Math.min(small, absnum);
                }
            }

            if (found) return ts;
            if (ncunt % 2 == 0) return ts;
            return ts - 2L * small;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = {
            {1, -2, 3},
            {-4, 5, -6},
            {7, -8, 9}
        };

        long result = sol.maxMatrixSum(matrix);
        System.out.println(result);
    }
}
