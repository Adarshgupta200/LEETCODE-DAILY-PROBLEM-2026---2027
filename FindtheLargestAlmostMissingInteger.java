class FindtheLargestAlmostMissingInteger {
    public static int findLargestAlmostMissingInteger(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];

        for (int num : arr) {
            if (num >= 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = n; i >= 0; i--) {
            if (!present[i]) {
                return i;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5};
        int result = findLargestAlmostMissingInteger(arr);
        System.out.println("The largest almost missing integer is: " + result);
    }
}