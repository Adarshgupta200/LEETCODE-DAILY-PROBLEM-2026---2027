class CountCommasinRange {
    public int countCommas(int n) {
        int commas = 0;
        long base = 1000;
        
        while (n >= base) {
            commas += (n - base + 1);
            base *= 1000;
        }
        
        return commas;
    }
    public static void main(String[] args) {
        CountCommasinRange obj = new CountCommasinRange();
        int n = 1000000;
        int result = obj.countCommas(n);
        System.out.println(result);
    }
}