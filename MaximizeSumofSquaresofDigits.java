class MaximizeSumofSquaresofDigits {
    public String maxSumOfSquares(int num, long sum) {
        if(sum<1||sum>(long)num*9)return"";
        StringBuilder sb=new StringBuilder();
        long cur=sum;
        for(int i=0;i<num;i++){
            long rem=num-1-i;
            long minD=Math.max(0,cur-rem*9);
            if(i==0&&num>1)minD=Math.max(minD,1);
            long maxD=Math.min(9,cur);
            if(minD>maxD)return"";
            sb.append(maxD);
            cur-=maxD;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        MaximizeSumofSquaresofDigits obj = new MaximizeSumofSquaresofDigits();
        int num = 3;
        long sum = 14;
        String result = obj.maxSumOfSquares(num, sum);
        
        // Print the result
        System.out.println(result); // Output: 950
    }
}