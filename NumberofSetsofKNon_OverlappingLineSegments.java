class NumberofSetsofKNon_OverlappingLineSegments {
    static final long MOD=1000000007;

    public int numberOfSets(int n,int k) {
        long ans=1;

        for(int i=1;i<=2*k;i++){
            ans=ans*(n+k-i)%MOD;
            ans=ans*pow(i,MOD-2)%MOD;
        }

        return (int)ans;
    }

    long pow(long a,long b){
        long ans=1;

        while(b>0){
            if((b&1)==1)
                ans=ans*a%MOD;

            a=a*a%MOD;
            b/=2;
        }

        return ans;
    }
    public static void main(String[] args) {
        NumberofSetsofKNon_OverlappingLineSegments obj = new NumberofSetsofKNon_OverlappingLineSegments();
        int n = 5;
        int k = 2;
        int result = obj.numberOfSets(n, k);
        System.out.println(result); // Output the number of sets of k non-overlapping line segments
    }
}