class StoneRemovalGame {
    public boolean canAliceWin(int n) {
        int a=10;
        boolean b=false;
        while(n>=a){
            n-=a;
            a--;
            b=!b;
        }
        return b;
    }
    public static void main(String[] args) {
        StoneRemovalGame obj = new StoneRemovalGame();
        int n = 15;
        System.out.println(obj.canAliceWin(n)); // Output: true
    }
}