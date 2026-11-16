class CalculateDigitSumofaString {
    public String digitSum(String a,int b){
        while(a.length()>b){
            StringBuilder c=new StringBuilder();
            for(int d=0;d<a.length();d+=b){
                int e=0;
                int f=Math.min(d+b,a.length());
                for(int g=d;g<f;g++){
                    e+=a.charAt(g)-'0';
                }
                c.append(e);
            }
            a=c.toString();
        }
        return a;
    }
    public static void main(String[] args) {
        CalculateDigitSumofaString solution = new CalculateDigitSumofaString();
        String a = "11111222223";
        int b = 3;
        String result = solution.digitSum(a, b);
        System.out.println(result); // Output: "135"
    }
}