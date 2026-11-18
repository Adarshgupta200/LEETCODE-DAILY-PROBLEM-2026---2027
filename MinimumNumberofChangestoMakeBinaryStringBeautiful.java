class MinimumNumberofChangestoMakeBinaryStringBeautiful {
    public int minChanges(String s) {
        int changes = 0;
            for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }
        
        return changes;
    }
    public static void main(String[] args) {
        MinimumNumberofChangestoMakeBinaryStringBeautiful solution = new MinimumNumberofChangestoMakeBinaryStringBeautiful();
        String s = "010101";
        int result = solution.minChanges(s);
        System.out.println(result); // Output: 0
    }
}