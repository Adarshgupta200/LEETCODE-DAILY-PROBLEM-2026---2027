class SmallestPalindromicRearrangementI3217 {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];
        for (char c:s.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder left= new StringBuilder();
        char mid=0;
        for (int i=0;i< 26; i++){
            while(count[i]>=2){
                left.append((char)(i + 'a'));
                count[i]-=2;
            }
            if(count[i]== 1){
                mid =(char)(i + 'a');
            }
        }
        StringBuilder ans =new StringBuilder();
        ans.append(left);
        if(mid!=0){
            ans.append(mid);
        }
        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }
  
    public static void main(String[] args) {        
        SmallestPalindromicRearrangementI3217 obj = new SmallestPalindromicRearrangementI3217();
        String s = "egcfe";
        String res = obj.smallestPalindrome(s);
        System.out.println(res);
    }   
}