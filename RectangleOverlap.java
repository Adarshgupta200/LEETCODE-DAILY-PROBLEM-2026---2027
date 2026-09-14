class RectangleOverlap {
    public boolean isRectangleOverlap(int[] a, int[] b) {
        return a[0]<b[2]&&b[0]<a[2] && a[1]<b[3] && b[1]<a[3];
    }
    public static void main(String[] args) {
        RectangleOverlap obj = new RectangleOverlap();
        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};
        boolean result = obj.isRectangleOverlap(rec1, rec2);
        System.out.println(result); // Output: true
    }
}