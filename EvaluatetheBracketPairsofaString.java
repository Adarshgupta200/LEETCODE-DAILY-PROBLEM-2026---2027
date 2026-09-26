import java.util.*;
class EvaluatetheBracketPairsofaString {
    public String evaluate(String s,List<List<String>> knowledge){
        Map<String,String> m=new HashMap<>();
        for(List<String> l:knowledge){
            m.put(l.get(0),l.get(1));
        }
        StringBuilder a=new StringBuilder();
        int b=-1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                b=i;
            }else if(c==')'){
                String d=s.substring(b+1,i);
                a.append(m.getOrDefault(d,"?"));
                b=-1;
            }else if(b==-1){
                a.append(c);
            }
        }
        return a.toString();
    }
    public static void main(String[] args) {
        EvaluatetheBracketPairsofaString obj = new EvaluatetheBracketPairsofaString();
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(Arrays.asList("name", "bob"));
        knowledge.add(Arrays.asList("age", "two"));
        String result = obj.evaluate(s, knowledge);
        System.out.println(result); // Output: bobistwoyearsold
    }
}