import java.math.BigInteger;

public class ExtraLargeFactorials {


    static void extraLongFactorials(int n) {
        BigInteger factorials =  BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            BigInteger x = BigInteger.valueOf(i);
            factorials = factorials.multiply(x);
        }
        System.out.println(factorials);
    }

    public static void main(String[] args) {
        extraLongFactorials(25);
    }
}
