class MinimumMovestoEqualArrayElementsIII {
    public int minMoves(int[] a){
        int b=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>b) b=a[i];
        }
        int c=0;
        for(int i=0;i<a.length;i++){
            c+=b-a[i];
        }
        return c;
    }
    public static void main(String[] args) {
        MinimumMovestoEqualArrayElementsIII obj = new MinimumMovestoEqualArrayElementsIII();
        int[] a = {1, 2, 3};
        System.out.println(obj.minMoves(a));
    }
}    