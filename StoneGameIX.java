class StoneGameIX {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        } else {
            return Math.abs(count[1] - count[2]) > 2;
        }
    }
    public static void main(String[] args) {
        StoneGameIX s = new StoneGameIX();
        int[] stones = {1, 2, 3, 4, 5};
        System.out.println(s.stoneGameIX(stones));
    }

}