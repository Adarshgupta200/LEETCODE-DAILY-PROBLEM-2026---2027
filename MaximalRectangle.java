
import java.util.Stack;

public class MaximalRectangle {

    public static void main(String[] args) {
        
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };

        Solution sol = new Solution();
        int result = sol.maximalRectangle(matrix);
        System.out.println("Maximal Rectangle Area: " + result);
    }
}

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int n = matrix[0].length;
        int[] heights = new int[n + 1]; 
        int ans = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < n; i++) {
                heights[i] = row[i] == '1' ? heights[i] + 1 : 0;
            }

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= n; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    ans = Math.max(ans, h * w);
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
