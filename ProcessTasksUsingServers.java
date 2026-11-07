import java.util.*;
class ProcessTasksUsingServers {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });
        for (int i = 0; i < servers.length; i++) {
            free.offer(new int[]{servers[i], i});
        }
        int[] ans = new int[tasks.length];
        long time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);
            if (free.isEmpty()) {
                time = busy.peek()[0];
            }
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] curr = busy.poll();
                free.offer(new int[]{(int)curr[1], (int)curr[2]});
            }
            int[] best = free.poll();
            ans[i] = best[1];
            busy.offer(new long[]{time + tasks[i], best[0], best[1]});
        }
        return ans;
    }
    public static void main(String[] args) {
        ProcessTasksUsingServers ad = new ProcessTasksUsingServers();
        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1};
        int[] result = ad.assignTasks(servers, tasks);  
    }
}