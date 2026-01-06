import java.util.*;

public class MaximumLevelSumofaBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int level = 1;
            int mlevel = 0;
            int msum = Integer.MIN_VALUE;

            while (!q.isEmpty()) {
                int size = q.size();
                int sum = 0;

                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    sum += node.val;

                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }

                if (sum > msum) {
                    msum = sum;
                    mlevel = level;
                }

                level++;
            }

            return mlevel;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(
            1,
            new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
            new TreeNode(0)
        );

        int result = sol.maxLevelSum(root);
        System.out.println(result);
    }
}
