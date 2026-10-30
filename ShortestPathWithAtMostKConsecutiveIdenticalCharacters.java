import java.util.*;    
class ShortestPathWithAtMostKConsecutiveIdenticalCharacters {
    public int shortestPath(int n, int[][] e, String l, int k) {
        if(k==0)return -1;
        
        List<int[]>[] g=new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int i=0;i<e.length;i++){
            int u=e[i][0];
            int v=e[i][1];
            int w=e[i][2];
            g[u].add(new int[]{v,w});
        }
        
        int[][] d=new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(d[i],Integer.MAX_VALUE);
        }
        d[0][1]=0;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,1}); 
        
        while(!pq.isEmpty()){
            int[] t=pq.poll();
            int a=t[0]; 
            int b=t[1]; 
            int c=t[2]; 
            
            if(b==n-1)return a;
            if(a>d[b][c])continue;
            
            for(int[] x:g[b]){
                int v=x[0];
                int w=x[1];
                
                int nc=(l.charAt(v)==l.charAt(b))?c+1:1;
                int nd=a+w;
                
                if(nc<=k&&nd<d[v][nc]){
                    d[v][nc]=nd;
                    pq.offer(new int[]{nd,v,nc});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        ShortestPathWithAtMostKConsecutiveIdenticalCharacters obj = new ShortestPathWithAtMostKConsecutiveIdenticalCharacters();
        int n = 5;
        int[][] e = {{0,1,2},{1,2,3},{0,3,1},{3,4,4}};
        String l = "ababa";                 
        int k = 2;
        System.out.println(obj.shortestPath(n, e, l, k));   
        
    }
}