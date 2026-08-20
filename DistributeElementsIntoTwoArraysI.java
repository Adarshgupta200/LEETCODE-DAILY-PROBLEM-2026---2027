import java.util.*;
class DistributeElementsIntoTwoArraysI {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);
        for(int i=2; i<nums.length; i++){
            if(a.get(a.size()-1)> b.get(b.size()-1)){
                a.add(nums[i]);
            }else{
                b.add(nums[i]);
            }
        }
        int arr[] = new int[nums.length];
        int k=0;

        for(int i:a){
            arr[k++]=i;
        }
        for(int i:b){
            arr[k++]=i;
        }
        return arr;
    }
    public static void main(String[] args) {
        DistributeElementsIntoTwoArraysI dea = new DistributeElementsIntoTwoArraysI();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] result = dea.resultArray(nums);
        System.out.println("The resulting array is: " + Arrays.toString(result));
    }
}