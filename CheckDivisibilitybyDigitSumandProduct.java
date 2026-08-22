class CheckDivisibilitybyDigitSumandProduct {
    public boolean checkDivisibility(int n) {
        int x = n;
        int sum = 0;
        int product = 1;

        while(x>0){
            int d = x % 10;
            sum += d;
            product *= d;
            x /= 10;
        }

        return n % (sum + product) == 0;
    }
    public static void main(String[] args) {
        CheckDivisibilitybyDigitSumandProduct solution = new CheckDivisibilitybyDigitSumandProduct();
        int n = 123;
        System.out.println(solution.checkDivisibility(n));
    }
}