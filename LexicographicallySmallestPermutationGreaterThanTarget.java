class LexicographicallySmallestPermutationGreaterThanTarget {
    public String lexGreaterPermutation(String s,String target) {
        int[] cnt=new int[26];
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        char[] a=target.toCharArray();
        for(int i=0;i<target.length();i++){
            int x=a[i]-'a';
            if(cnt[x]>0){
                cnt[x]--;
            }
            else{
                for(int j=x+1;j<26;j++){
                    if(cnt[j]>0){
                        cnt[j]--;
                        StringBuilder ans=new StringBuilder();
                        for(int k=0;k<i;k++){
                            ans.append(a[k]);
                        }
                        ans.append((char)('a'+j));
                        for(int k=0;k<26;k++){
                            while(cnt[k]>0){
                                ans.append((char)('a'+k));
                                cnt[k]--;
                            }
                        }
                        return ans.toString();
                    }
                }
                for(int j=i-1;j>=0;j--){
                    cnt[a[j]-'a']++;
                    for(int k=a[j]-'a'+1;k<26;k++){
                        if(cnt[k]>0){
                            cnt[k]--;
                            StringBuilder ans=new StringBuilder();
                            for(int m=0;m<j;m++){
                                ans.append(a[m]);
                            }
                            ans.append((char)('a'+k));
                            for(int m=0;m<26;m++){
                                while(cnt[m]>0){
                                    ans.append((char)('a'+m));
                                    cnt[m]--;
                                }
                            }
                            return ans.toString();
                        }
                    }
                }
                return "";
            }
        }
        for(int i=target.length()-1;i>=0;i--){
            cnt[a[i]-'a']++;
            for(int j=a[i]-'a'+1;j<26;j++){
                if(cnt[j]>0){
                    cnt[j]--;
                    StringBuilder ans=new StringBuilder();
                    for(int k=0;k<i;k++){
                        ans.append(a[k]);
                    }
                    ans.append((char)('a'+j));
                    for(int k=0;k<26;k++){
                        while(cnt[k]>0){
                            ans.append((char)('a'+k));
                            cnt[k]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }
        return "";
    }
    public static void main(String[] args) {
        LexicographicallySmallestPermutationGreaterThanTarget solution = new LexicographicallySmallestPermutationGreaterThanTarget();
        String s = "abcde";
        String target = "abd";
        System.out.println(solution.lexGreaterPermutation(s, target));
    }
}