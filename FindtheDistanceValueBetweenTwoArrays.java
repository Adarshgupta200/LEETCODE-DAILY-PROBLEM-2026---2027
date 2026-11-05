class FindtheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        
        for (int x : arr1) {
            boolean valid = true;
            
            for (int y : arr2) {
                if (Math.abs(x - y) <= d) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) {
                count++;
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
        FindtheDistanceValueBetweenTwoArrays solution = new FindtheDistanceValueBetweenTwoArrays();
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        int result = solution.findTheDistanceValue(arr1, arr2, d);
        System.out.println("The distance value is: " + result); // Output: 2
    }
}