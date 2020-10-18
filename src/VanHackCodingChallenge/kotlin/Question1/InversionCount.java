package vanHackCodingChallenge.kotlin.Question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InversionCount {
    public static void main(String[] args) {
        InversionCount inversionCount = new InversionCount();
        Integer[] arr = {5, 3, 4, 2, 1};
        long sum = inversionCount.maxInversions(new ArrayList<>(Arrays.asList(arr)));
        System.out.println(sum);
    }

    public Long maxInversions(List<Integer> arr) {
        long inv_count = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            int countSmallerValues = 0;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    countSmallerValues++;
                }
            }
            int countBiggerValues = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(i) < arr.get(j)) {
                    countBiggerValues++;
                }
            }
            inv_count += countBiggerValues * countSmallerValues;
        }
        return inv_count;
    }
}
