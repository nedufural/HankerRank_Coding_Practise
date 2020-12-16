import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigSum {

    static long aVeryBigSum(long[] ar) {
        List<BigInteger> bigIntegers = new ArrayList<>();
        BigInteger sum;
        BigInteger total;
        for (long l : ar) {
            bigIntegers.add(BigInteger.valueOf(l));
        }
        sum = bigIntegers.get(0);
        for (int i = 1; i < bigIntegers.size(); i++) {
            sum = sum.add(bigIntegers.get(i));
        }

    return  sum.longValue();
    }

    public static void main(String[] args) {
        long [] i = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};

        System.out.println(aVeryBigSum(i));
    }
}
