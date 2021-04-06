import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Miscell {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 4, 3, 5};
        int[] num2 = {7, 6, 8, 10, 9};

        //int[] num1 = {1, 2};
        //int[] num2 = {3, 4};

        //int[] num1 = {0, 0};
        //int[] num2 = {0, 0};

        //int[] num1 = {};
        //int[] num2 = {1};

        //int[] num1 = {2};
        //int[] num2 = {};

        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] finalArray = IntStream
                .concat(
                        Arrays.stream(nums1)
                                .sorted(),
                        Arrays.stream(nums2)
                                .sorted())
                .toArray();
        finalArray = Arrays.stream(finalArray).sorted().toArray();
        double middleNumber = (finalArray.length) % (2);
        int num, sum;
        num = (finalArray.length) / (2);
        if (middleNumber == 0) {
            sum = finalArray[num-1] + finalArray[num];
            System.out.println(decimalPlaces(2));
            return decimalPlaces((float) sum / 2f);
        } else {
            sum = finalArray[num];
            return decimalPlaces(sum);
        }
    }

    public static float decimalPlaces(float decimal){

       return Float.parseFloat(String.format(java.util.Locale.US,"%.004f", decimal));

    }
}
