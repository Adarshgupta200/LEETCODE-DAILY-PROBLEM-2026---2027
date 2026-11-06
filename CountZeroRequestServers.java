import java.util.*;
class CountZeroRequestServers {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        
        int m = queries.length;
        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        
        int[] ans = new int[m];
        int[] count = new int[n + 1];
        int active = 0;
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < m; i++) {
            int end = q[i][0];
            int start = end - x;
            
            while (right < logs.length && logs[right][1] <= end) {
                if (count[logs[right][0]] == 0) {
                    active++;
                }
                count[logs[right][0]]++;
                right++;
            }
            
            while (left < logs.length && logs[left][1] < start) {
                count[logs[left][0]]--;
                if (count[logs[left][0]] == 0) {
                    active--;
                }
                left++;
            }
            
            ans[q[i][1]] = n - active;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        CountZeroRequestServers solution = new CountZeroRequestServers();
        int n = 3;
        int[][] logs = {{1, 3}, {2, 6}, {1, 5}};
        int x = 5;
        int[] queries = {5, 10};
        int[] result = solution.countServers(n, logs, x, queries);
        System.out.println("The count of servers with zero requests: " + Arrays.toString(result)); // Output: [1, 2]
    }
}