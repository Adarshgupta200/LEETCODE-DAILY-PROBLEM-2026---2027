class LexicographicallySmallestPalindromicPermutationGreaterThanTarget {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int h = n / 2;

        int[] a = new int[26];

        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }

        int odd = 0;
        char mid = ' ';

        for (int i = 0; i < 26; i++) {
            if (a[i] % 2 != 0) {
                odd++;
                mid = (char)(i + 'a');
            }
        }

        if (odd > 1) {
            return "";
        }

        int[] b = new int[26];

        for (int i = 0; i < 26; i++) {
            b[i] = a[i] / 2;
        }

        for (int k = h; k >= 0; k--) {
            int[] c = new int[26];

            for (int i = 0; i < k; i++) {
                c[target.charAt(i) - 'a']++;
            }

            boolean ok = true;
            int[] d = new int[26];

            for (int i = 0; i < 26; i++) {
                if (b[i] < c[i]) {
                    ok = false;
                    break;
                }

                d[i] = b[i] - c[i];
            }

            if (!ok) {
                continue;
            }

            if (k == h) {
                String x = target.substring(0, h);
                String ans = make(x, mid, n);

                if (ans.compareTo(target) > 0) {
                    return ans;
                }
            } else {
                char x = target.charAt(k);
                int y = -1;

                for (int i = x - 'a' + 1; i < 26; i++) {
                    if (d[i] > 0) {
                        y = i;
                        break;
                    }
                }

                if (y != -1) {
                    StringBuilder x1 = new StringBuilder();

                    x1.append(target.substring(0, k));
                    x1.append((char)(y + 'a'));

                    d[y]--;

                    for (int i = 0; i < 26; i++) {
                        while (d[i] > 0) {
                            x1.append((char)(i + 'a'));
                            d[i]--;
                        }
                    }

                    return make(x1.toString(), mid, n);
                }
            }
        }

        return "";
    }

    private String make(String a, char mid, int n) {
        StringBuilder b = new StringBuilder(a);

        if (n % 2 != 0) {
            b.append(mid);
        }

        for (int i = a.length() - 1; i >= 0; i--) {
            b.append(a.charAt(i));
        }

        return b.toString();
    }
    public static void main(String[] args) {
        LexicographicallySmallestPalindromicPermutationGreaterThanTarget solution = new LexicographicallySmallestPalindromicPermutationGreaterThanTarget();
        System.out.println(solution.lexPalindromicPermutation("deed", "deed")); // Expected: ""
        System.out.println(solution.lexPalindromicPermutation("abc", "abc")); // Expected: ""   
    }
}