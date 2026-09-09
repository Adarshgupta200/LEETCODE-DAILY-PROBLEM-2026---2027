class CountCommasinRangeII {
    public long countCommas(long n) {
        long commas = 0;
        long base = 1000;
        while(n>=base){
            commas += (n-base + 1);
            base*=1000;
        }
        return commas;
    }
    public static void main(String[] args) {
        CountCommasinRangeII obj = new CountCommasinRangeII();
        long n = 1000000;
        long result = obj.countCommas(n);
        System.out.println(result);
    }
}