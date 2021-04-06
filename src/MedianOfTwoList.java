import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoList {


    private static boolean isEven(int merged) {
        return merged % 2 != 1;
    }

    private static double medianEven(List<Integer> merge, int middle) {
        return merge.get(middle) / 2.0;
    }

    private static double medianOdd(List<Integer> merge, int middle) {
        return (merge.get(middle) + merge.get(middle - 1)) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        MedianOfTwoList medianOfTwoList = new MedianOfTwoList();
        System.out.println(medianOfTwoList.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merged = new ArrayList<Integer>();
        for (int k : nums1) {
            merged.add(k);
        }
        for (int i : nums2) {
            merged.add(i);
        }
        Collections.sort(merged);
        merged.forEach(System.out::println);
        int middle;
        if (!isEven(merged.size())) {
            middle = (int) Math.ceil(merged.size() / 2.0);
            return merged.get(middle - 1);

        } else {
            middle = Math.floorDiv(merged.size(), 2);
            return medianOdd(merged, middle);
        }
    }
}
