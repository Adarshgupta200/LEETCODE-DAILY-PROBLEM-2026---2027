import java.util.*;
class SubarraysDistinctElementSumofSquaresI {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();
        
        for (int i = 0; i < n; i++) {
            Set<Integer> distinctElements = new HashSet<>();
            for (int j = i; j < n; j++) {
                distinctElements.add(nums.get(j));
                int count = distinctElements.size();
                totalSum += count * count;
            }
        }
        
        return totalSum;
    }
    public static void main(String[] args) {
        SubarraysDistinctElementSumofSquaresI obj = new SubarraysDistinctElementSumofSquaresI();
        List<Integer> nums = Arrays.asList(1, 2, 1);
        int result = obj.sumCounts(nums);
        
        // Print the result
        System.out.println(result); // Output: 14
    }
}