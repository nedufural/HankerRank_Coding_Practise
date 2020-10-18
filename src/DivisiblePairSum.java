import java.util.ArrayList;
import java.util.List;

public class DivisiblePairSum {

    static int divisibleSumPairs(int n, int k, int[] ar) {

        List<Integer> arrElement = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(ar[i]%k!=0){
               arrElement.add(ar[i]);
            }
        }
        return arrElement.size();
}

    public static void main(String[] args) {
        int[] ar = {1, 3, 2, 6, 1, 2};
        System.out.println(divisibleSumPairs(6, 3, ar));
    }
}
