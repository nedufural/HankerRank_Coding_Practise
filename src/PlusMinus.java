import java.text.DecimalFormat;

public class PlusMinus {
    static void plusMinus(int[] arr) {
        int temp = arr[0];
        int countPositive = 0;
        int countNegative = 0;
        int countZeros = 0;
        for (int j : arr) {
            if (j < 0) {
                countNegative++;
            }
        }
        for (int j : arr) {
            if (j > 0) {
                countPositive++;
            }
        }
        for (int j : arr) {
            if (j == 0) {
                countZeros++;
            }
        }

        double negative = countNegative / (double) arr.length;
        double positive = countPositive / (double) arr.length;
        double zero = countZeros / (double) arr.length;
        System.out.println(decimalConverter(negative) + " " + decimalConverter(positive) + " " + decimalConverter(zero));
    }

    public static void main(String[] args) {
        int[] arr = {-4, 3, -9, 0, 4, 1};
        long start2 = System.currentTimeMillis();
        plusMinus(arr);
        long end2 = System.currentTimeMillis();
        long elapsedTime2 = end2 - start2;
        System.out.println(elapsedTime2);

    }

    private static String decimalConverter(double num) {
        DecimalFormat df = new DecimalFormat("0.0000");
        return df.format(num);
    }
}
