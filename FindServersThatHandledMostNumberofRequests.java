import java.util.*;
class FindServersThatHandledMostNumberofRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }
        
        PriorityQueue<int[]> runningJobs = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] requestsHandled = new int[k];
        
        for (int i = 0; i < arrival.length; i++) {
            int startTime = arrival[i];
            int duration = load[i];
            
            while (!runningJobs.isEmpty() && runningJobs.peek()[0] <= startTime) {
                int[] finishedJob = runningJobs.poll();
                int finishedServerId = finishedJob[1];
                availableServers.add(finishedServerId);
            }
            
            if (availableServers.isEmpty()) {
                continue;
            }
            
            int preferredServerId = i % k;
            Integer chosenServer = availableServers.ceiling(preferredServerId); 
            
            if (chosenServer == null) {
                chosenServer = availableServers.first();
            }
            
            requestsHandled[chosenServer]++;
            availableServers.remove(chosenServer); 
            
            int finishTime = startTime + duration;
            runningJobs.offer(new int[] {finishTime, chosenServer}); 
        }
        
        int maxRequests = 0;
        for (int count : requestsHandled) {
            maxRequests = Math.max(maxRequests, count);
        }
        
        List<Integer> busiestServersList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestsHandled[i] == maxRequests) {
                busiestServersList.add(i);
            }
        }
        
        return busiestServersList;
    }
    public static void main(String[] args) {
        FindServersThatHandledMostNumberofRequests solution = new FindServersThatHandledMostNumberofRequests();
        int k = 3;
        int[] arrival = {1, 2, 3, 4, 5};
        int[] load = {5, 2, 3, 3, 3};
        List<Integer> result = solution.busiestServers(k, arrival, load);
        System.out.println(result); // Output: [1]  
    }
}