class TwistedMirrorPathCount {
    public int uniquePaths(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int mod=1000000007;
        long[][] r=new long[m+1][n+1];
        long[][] d=new long[m+1][n+1];
        r[0][1]=1;
        d[1][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0)continue;
                long a=r[i][j];
                long b=d[i][j];
                if(a==0&&b==0)continue;
                if(grid[i][j]==0){
                    long c=(a+b)%mod;
                    if(i==m-1&&j==n-1)return (int)c;
                    r[i][j+1]=(r[i][j+1]+c)%mod;
                    d[i+1][j]=(d[i+1][j]+c)%mod;
                }else{
                    d[i+1][j]=(d[i+1][j]+a)%mod;
                    r[i][j+1]=(r[i][j+1]+b)%mod;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        TwistedMirrorPathCount obj = new TwistedMirrorPathCount();
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}}; 
        System.out.println(obj.uniquePaths(grid));
    }
}