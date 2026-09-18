
import java.util.*;            
class  MaximumNumberofNon_OverlappingSubstrings {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, n);
        Arrays.fill(right, -1);

        for (int i = 0; i < n; ++i) {
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = i;
        }

        List<String> ans = new ArrayList<>();
        int lastEnd = -1;

        for (int i = 0; i < n; ++i) {
            int c = s.charAt(i) - 'a';
            if (i != left[c]) continue;
            
            int newRight = getValidRight(s, i, left, right);
            if (newRight == -1) continue;

            if (i <= lastEnd) {
                ans.set(ans.size() - 1, s.substring(i, newRight + 1));
            } else {
                ans.add(s.substring(i, newRight + 1));
            }
            lastEnd = newRight;
        }

        return ans;
    }

    private int getValidRight(String s, int i, int[] left, int[] right) {
        int res = right[s.charAt(i) - 'a'];
        for (int j = i; j <= res; ++j) {
            int c = s.charAt(j) - 'a';
            if (left[c] < i) return -1;
            res = Math.max(res, right[c]);
        }
        return res;
    }
    public static void main(String[] args) {
        MaximumNumberofNon_OverlappingSubstrings obj = new MaximumNumberofNon_OverlappingSubstrings();
        String s = "adefaddaccc";
        List<String> result = obj.maxNumOfSubstrings(s);
        System.out.println(result); // Output the maximum number of non-overlapping substrings
    }
}