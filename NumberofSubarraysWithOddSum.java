class NumberofSubarraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int a = 1; 
        int b = 0; 
        long c = 0; 
        int sum = 0; 
        int mod = 1000000007; 

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; 
            
            if (sum % 2 == 0) { 
                c += b; 
                a++; 
            } else { 
                c += a; 
                b++; 
            }
        }
        
        return (int) (c % mod);
    }
    public static void main(String[] args) {
        NumberofSubarraysWithOddSum solution = new NumberofSubarraysWithOddSum();
        int[] arr = {1, 2, 3, 4, 5};
        int result = solution.numOfSubarrays(arr);
        System.out.println(result); // Output: 9
    }
}