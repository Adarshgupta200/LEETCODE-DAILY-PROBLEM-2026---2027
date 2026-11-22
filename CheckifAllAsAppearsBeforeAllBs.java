class CheckifAllAsAppearsBeforeAllBs {
    public boolean checkString(String s) {
        int a=s.length();
        int b=0;
        for(int c=0;c<a;c++){
            if(s.charAt(c)=='b'){
                b=1;
            }else if(b==1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        CheckifAllAsAppearsBeforeAllBs ad = new CheckifAllAsAppearsBeforeAllBs();
        String str = "aaabbb";
        System.out.println(ad.checkString(str));
    }
}