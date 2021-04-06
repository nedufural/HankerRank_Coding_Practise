import java.util.Arrays;

interface PerformOperation {
    boolean check(int a);
}


class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation isPrime() {
        return a -> {
            // Corner cases
            if (a <= 1) {
                return false;
            }
            if (a <= 3) {
                return true;
            }
            // This is checked so that we can skip
            // middle five numbers in below loop
            if (a % 2 == 0 || a % 3 == 0) {
                return false;
            }
            for (int i = 5; i * i <= a; i = i + 6) {
                if (a % i == 0 || a % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        };
    }

    PerformOperation isPalindrome() {

        return a -> {
            char[] original = String.valueOf(a).toCharArray();
            char[] reversed = new char[original.length];
            int position = 0;
            for (int i = original.length - 1; i >= 0; i--) {
                reversed[position] = original[i];
                position++;
            }
            return Arrays.equals(original, reversed);
        };
    }

    PerformOperation isOdd() {
        return a -> a % 2 == 1;
    }
}

public class LambdaExpression {


    public static void main(String[] args) {
        MyMath ob = new MyMath();
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        int ch = 1;
        int num = 191;
        if (ch == 1) {
            op = ob.isOdd();
            ret = MyMath.checker(op, num);
            ans = (ret) ? "ODD" : "EVEN";
        } else if (ch == 2) {
            op = ob.isPrime();
            ret = MyMath.checker(op, num);
            ans = (ret) ? "PRIME" : "COMPOSITE";
        } else if (ch == 3) {
            op = ob.isPalindrome();
            ret = MyMath.checker(op, num);
            ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

        }
        System.out.println(ans);
      Thread thread =  new Thread();
    }
}