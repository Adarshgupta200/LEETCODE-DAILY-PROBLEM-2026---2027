class NumberofClosedIslands {
    int[] p;
    boolean[] b;
    
    public int closedIsland(int[][] g){
        int m=g.length;
        int n=g[0].length;
        p=new int[m*n];
        b=new boolean[m*n];
        
        for(int i=0;i<m*n;i++){
            p[i]=i;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==0){
                    if(i==0||i==m-1||j==0||j==n-1){
                        b[i*n+j]=true;
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==0){
                    if(i+1<m&&g[i+1][j]==0){
                        u(i*n+j,(i+1)*n+j);
                    }
                    if(j+1<n&&g[i][j+1]==0){
                        u(i*n+j,i*n+j+1);
                    }
                }
            }
        }
        
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int id=i*n+j;
                if(g[i][j]==0&&p[id]==id&&!b[id]){
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private int f(int x){
        if(p[x]==x) return x;
        return p[x]=f(p[x]);
    }
    
    private void u(int x,int y){
        int rx=f(x);
        int ry=f(y);
        if(rx!=ry){
            p[rx]=ry;
            b[ry]=b[ry]||b[rx];
        }
    }
    public static void main(String[] args) {
        NumberofClosedIslands solution = new NumberofClosedIslands();
        int[][] grid = {
            {1, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1}
        };
        
        int closedIslands = solution.closedIsland(grid);
        System.out.println("Number of closed islands: " + closedIslands);
    }
}