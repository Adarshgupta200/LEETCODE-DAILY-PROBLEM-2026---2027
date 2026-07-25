class MaximumProductofTwoDigits3536 {
    public int maxProduct(int n) {
        int first = 0;
        int second =0;
        while(n>0){
            int d=n% 10;
            if(d>=first){
                second =first;
                first=d;
            }else if(d >second){
                second = d;
            }
            n/=10;
        }

        return first*second;
    }
    public static void main(String[] args) {
        MaximumProductofTwoDigits3536 obj = new MaximumProductofTwoDigits3536();
        int n = 23;
        int res = obj.maxProduct(n);
        System.out.println(res);
    }
}