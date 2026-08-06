class SmallestDivisibleDigitProductI {
    public int smallestNumber(int n, int t) {
        while(true){
            int a = n;
            int b = 1;
            while(a > 0){
                b *= a % 10;
                a /= 10;
            }
            if(b % t == 0){
                return n;
            }
            n++;
        }
    }
    public static void main(String[] args) {
        SmallestDivisibleDigitProductI obj = new SmallestDivisibleDigitProductI();
        int n = 10;
        int t = 5;
        int res = obj.smallestNumber(n, t);
        System.out.println(res);
    }
}