import java.util.*;
class Solution {
    int[] bit;
    int nNodes;

    void updateBit(int idx,int val){
        for(;idx<=nNodes;idx+=idx&-idx)bit[idx]^=val;
    }

    void addRange(int l,int r,int val){
        updateBit(l,val);
        updateBit(r+1,val);
    }

    int queryPoint(int idx){
        int res=0;
        for(;idx>0;idx-=idx&-idx)res^=bit[idx];
        return res;
    }

    int getLca(int u,int v,int[] depth,int[][] up,int LOG){
        if(depth[u]<depth[v]){
            int t=u;u=v;v=t;
        }
        int diff=depth[u]-depth[v];
        for(int k=0;k<LOG;k++){
            if(((diff>>k)&1)==1)u=up[k][u];
        }
        if(u==v)return u;
        for(int k=LOG-1;k>=0;k--){
            if(up[k][u]!=up[k][v]){
                u=up[k][u];
                v=up[k][v];
            }
        }
        return up[0][u];
    }

    public List<Boolean> palindromePath(int n,int[][] edges,String s,String[] queries){
        nNodes=n;
        int LOG=17;
        int[] head=new int[n];
        Arrays.fill(head,-1);
        int[] to=new int[2*(n-1)];
        int[] next=new int[2*(n-1)];
        int edgeCnt=0;
        for(int[] e:edges){
            int u=e[0],v=e[1];
            to[edgeCnt]=v;next[edgeCnt]=head[u];head[u]=edgeCnt++;
            to[edgeCnt]=u;next[edgeCnt]=head[v];head[v]=edgeCnt++;
        }

        int[][] up=new int[LOG][n];
        int[] depth=new int[n];
        int[] tin=new int[n];
        int[] tout=new int[n];
        int timer=0;

        int[] stackU=new int[2*n];
        int[] stackP=new int[2*n];
        int[] stackState=new int[2*n];
        int top=0;

        stackU[top]=0;stackP[top]=0;stackState[top]=0;top++;

        while(top>0){
            top--;
            int u=stackU[top];
            int p=stackP[top];
            int state=stackState[top];
            if(state==0){
                tin[u]=++timer;
                up[0][u]=p;
                stackU[top]=u;stackP[top]=p;stackState[top]=1;top++;
                for(int e=head[u];e!=-1;e=next[e]){
                    int v=to[e];
                    if(v!=p){
                        depth[v]=depth[u]+1;
                        stackU[top]=v;stackP[top]=u;stackState[top]=0;top++;
                    }
                }
            }else{
                tout[u]=timer;
            }
        }

        for(int k=1;k<LOG;k++){
            for(int i=0;i<n;i++){
                up[k][i]=up[k-1][up[k-1][i]];
            }
        }

        bit=new int[n+2];
        int[] masks=new int[n];
        for(int i=0;i<n;i++){
            masks[i]=1<<(s.charAt(i)-'a');
            addRange(tin[i],tout[i],masks[i]);
        }

        List<Boolean> ans=new ArrayList<>();
        for(String q:queries){
            if(q.charAt(0)=='u'){
                int u=0,i=7;
                while(q.charAt(i)!=' '){
                    u=u*10+(q.charAt(i)-'0');
                    i++;
                }
                char c=q.charAt(i+1);
                int newMask=1<<(c-'a');
                int diff=masks[u]^newMask;
                if(diff!=0){
                    masks[u]=newMask;
                    addRange(tin[u],tout[u],diff);
                }
            }else{
                int u=0,v=0,i=6,len=q.length();
                while(q.charAt(i)!=' '){
                    u=u*10+(q.charAt(i)-'0');
                    i++;
                }
                i++;
                while(i<len){
                    v=v*10+(q.charAt(i)-'0');
                    i++;
                }
                int lca=getLca(u,v,depth,up,LOG);
                int pathMask=queryPoint(tin[u])^queryPoint(tin[v])^masks[lca];
                ans.add((pathMask&(pathMask-1))==0);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
        String s = "abcde";
        String[] queries = {"u 1 x", "q 3 4", "q 2 4"};
        List<Boolean> result = solution.palindromePath(n, edges, s, queries);
        System.out.println(result); // Output: [true, false]
    }
}