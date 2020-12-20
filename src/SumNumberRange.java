import java.util.Arrays;

interface CalculateSum {
    int sumCalculatorInterface(int[] arr);
}

public class SumNumberRange {


    public static void main(String[] s) {
        MyMathClass myMathClass = new MyMathClass();
        CalculateSum  calculateSum ;
        calculateSum = myMathClass.sum();
        int[] b = {5, 10};
        Arrays.sort(b);
        int result = MyMathClass.calculatorImpl(calculateSum,b);
        System.out.println(result);
    }
}

class MyMathClass {
    public static int calculatorImpl(CalculateSum p, int[] arr) {
        return p.sumCalculatorInterface(arr);
    }

    CalculateSum sum() {

        return arr1 -> {
            Arrays.sort(arr1);
            int temp = arr1[0];
            int sumArray = 0;
            int sumBtwArray = 0;
            for (int j : arr1) {
                sumArray += j;
            }
            for (int i = 0; i < (arr1[1] - arr1[0]) - 1; i++) {
                    temp++;
                    sumBtwArray += temp;
            }
            return sumArray + sumBtwArray;
        };
    }
}