import java.util.*;

public class ProductoftheLastKNumbers {
    private List<Integer> prefix;

    public ProductoftheLastKNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix = new ArrayList<>();
            prefix.add(1);
        } else {
            int last = prefix.get(prefix.size() - 1);
            prefix.add(last * num);
        }
    }

    public int getProduct(int k) {
        int n = prefix.size();
        if (k >= n) {
            return 0;
        }
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }

    public static void main(String[] args) {
        ProductoftheLastKNumbers obj = new ProductoftheLastKNumbers();
        obj.add(3);
        obj.add(0);
        obj.add(2);
        obj.add(5);
        obj.add(4);
        System.out.println(obj.getProduct(2));
        System.out.println(obj.getProduct(3));
        System.out.println(obj.getProduct(4));
        obj.add(8);
        System.out.println(obj.getProduct(2));
    }
}