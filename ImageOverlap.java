class ImageOverlap {
    public int largestOverlap(int[][] img1,int[][] img2) {
        int n=img1.length;
        int ans=0;
        for(int x=-(n-1);x<n;x++){
            for(int y=-(n-1);y<n;y++){
                int cnt=0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        int a=i+x;
                        int b=j+y;
                        if(a>=0&&a<n&&b>=0&&b<n){
                            if(img1[i][j]==1&&img2[a][b]==1){
                                cnt++;
                            }
                        }
                    }
                }
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ImageOverlap obj = new ImageOverlap();
        int[][] img1 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        };
        int[][] img2 = {
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 1}
        };
        int result = obj.largestOverlap(img1, img2);
        System.out.println(result); 
    }
}