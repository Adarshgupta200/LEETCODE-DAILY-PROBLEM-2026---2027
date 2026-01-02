import java.util.*;
public class RepeatedElementinSize2NArray {
    public static int repeatedNtimes(int [] nums){
        HashMap<Integer, Integer> ad = new HashMap<>();
        for(int num : nums){
            ad.put(num, ad.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : ad.entrySet()){
            if(entry.getValue()>1){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr [] = {1,44,5,6,7,7,8,9,0,5,6,7,8,9,9};
       int ada = repeatedNtimes(arr);
       System.out.println(ada);

    }
}
