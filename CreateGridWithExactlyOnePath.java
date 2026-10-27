class  CreateGridWithExactlyOnePath{
    public String[] createGrid(int m,int n){
        String[] a=new String[m];
        for(int i=0;i<m;i++){
            char[] b=new char[n];
            for(int j=0;j<n;j++)b[j]='#';
            a[i]=new String(b);
        }
        for(int i=0;i<m;i++){
            char[] b=a[i].toCharArray();
            if(i==0)b[0]='.';
            else b[0]='#';
            a[i]=new String(b);
        }
        char[] b=a[0].toCharArray();
        for(int j=0;j<n;j++)b[j]='.';
        a[0]=new String(b);
        for(int i=1;i<m;i++){
            char[] c=a[i].toCharArray();
            c[n-1]='.';
            a[i]=new String(c);
        }
        return a;
    }
    public static void main(String[] args) {
        CreateGridWithExactlyOnePath solution = new CreateGridWithExactlyOnePath();
        int m = 3;
        int n = 4;
        String[] grid = solution.createGrid(m, n);
        for (String row : grid) {
            System.out.println(row);
        }
    }
}