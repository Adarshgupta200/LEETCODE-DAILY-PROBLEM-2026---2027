import java.util.HashSet;
class LongestSubstringofOneRepeatingCharacter {int[] maxL, preL, sufL, len;
    char[] preC, sufC;
    char[] arr;
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        maxL = new int[4 * n];
        preL = new int[4 * n];
        sufL = new int[4 * n];
        len = new int[4 * n];
        preC = new char[4 * n];
        sufC = new char[4 * n];
        arr = s.toCharArray();
        build(1, 0, n - 1);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = maxL[1];
        }
        return ans;
    }
    private void merge(int node) {
        int l = 2 * node;
        int r = 2 * node + 1;
        len[node] = len[l] + len[r];
        preC[node] = preC[l];
        sufC[node] = sufC[r];
        preL[node] = preL[l];
        if (preL[l] == len[l] && preC[l] == preC[r]) {
            preL[node] += preL[r];
        }
        sufL[node] = sufL[r];
        if (sufL[r] == len[r] && sufC[r] == sufC[l]) {
            sufL[node] += sufL[l];
        }
        maxL[node] = Math.max(maxL[l], maxL[r]);
        if (sufC[l] == preC[r]) {
            maxL[node] = Math.max(maxL[node], sufL[l] + preL[r]);
        }
    }
    private void build(int node, int start, int end) {
        if (start == end) {
            maxL[node] = preL[node] = sufL[node] = len[node] = 1;
            preC[node] = sufC[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        merge(node);
    }
    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            preC[node] = sufC[node] = c;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, c);
        } else {
            update(2 * node + 1, mid + 1, end, idx, c);
        }
        merge(node);
    }
    public static void main(String[] args) {
        LongestSubstringofOneRepeatingCharacter obj = new LongestSubstringofOneRepeatingCharacter();
        String s = "babacc";
        String queryCharacters = "bcb"; 
        int[] queryIndices = {1, 3, 3};
        int[] res = obj.longestRepeating(s, queryCharacters, queryIndices);
        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}