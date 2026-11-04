import java.util.*;
class MinimumOperationstoMakeElementsWithinKSubarraysEqual {
    TreeSet<Integer> s1, s2;
    long sum1 = 0, sum2 = 0;
    int[] arr;

    public long minOperations(int[] nums, int x, int k) {
        arr = nums;
        int n = nums.length;

        Comparator<Integer> comp = (a, b) -> arr[a] != arr[b] 
                ? Integer.compare(arr[a], arr[b]) 
                : Integer.compare(a, b);
                
        s1 = new TreeSet<>(comp);
        s2 = new TreeSet<>(comp);

        long[] cost = new long[n];

        for (int i = 0; i < n; i++) {
            add(i);
            if (i >= x) {
                remove(i - x);
            }
            if (i >= x - 1) {
                long mid = arr[s1.last()];
                cost[i] = (mid * s1.size() - sum1) + (sum2 - mid * s2.size());
            }
        }

        long[] dp = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            long[] temp = new long[n + 1];
            Arrays.fill(temp, Long.MAX_VALUE / 2);
            
            for (int i = j * x; i <= n; i++) {
                temp[i] = Math.min(temp[i - 1], dp[i - x] + cost[i - 1]);
            }
            dp = temp;
        }

        return dp[n];
    }

    void add(int i) {
        if (!s1.isEmpty() && arr[i] > arr[s1.last()]) {
            s2.add(i);
            sum2 += arr[i];
        } else {
            s1.add(i);
            sum1 += arr[i];
        }
        fix();
    }

    void remove(int i) {
        if (s1.remove(i)) {
            sum1 -= arr[i];
        } else {
            s2.remove(i);
            sum2 -= arr[i];
        }
        fix();
    }

    void fix() {
        while (s1.size() > s2.size() + 1) {
            int i = s1.pollLast();
            sum1 -= arr[i];
            s2.add(i);
            sum2 += arr[i];
        }
        while (s1.size() < s2.size()) {
            int i = s2.pollFirst();
            sum2 -= arr[i];
            s1.add(i);
            sum1 += arr[i];
        }
    }
    public static void main(String[] args) {
        MinimumOperationstoMakeElementsWithinKSubarraysEqual obj = new MinimumOperationstoMakeElementsWithinKSubarraysEqual();
        int[] nums = {1, 2, 3, 4, 5};
        int x = 2;
        int k = 2;
        System.out.println(obj.minOperations(nums, x, k));
    }
}