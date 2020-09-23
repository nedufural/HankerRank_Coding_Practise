package GraduateAlgorithms_Udacity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long statTime = new Date().getTime();
        System.out.print(fibonacci.fibonacciRecursive(45));
        long endTime = new Date().getTime();
        System.out.println(": Time 1 : "+(statTime - endTime));


        long statTime1 = new Date().getTime();
        System.out.print(fibonacci.fibonacciDynamicProgramming(45));
        long endTime1 = new Date().getTime();
        System.out.println(": Time 2 : "+ (statTime1 - endTime1));

    }

    public int fibonacciRecursive(int nth) {
        if (nth <= 1){
            return nth;}
        return fibonacciRecursive(nth - 1) + fibonacciRecursive(nth - 2);
    }

    public int fibonacciDynamicProgramming(int nth) {
        List<Integer> addValues = new ArrayList<>();
        //declare the first 2 elements of the fibonacci
        addValues.add(0);
        addValues.add(1);
        for (int i = 2; i <= nth+2; i++) {
            addValues.add(addValues.get(i-1) + addValues.get(i-2));
        }
        return addValues.get(nth);
    }
}
