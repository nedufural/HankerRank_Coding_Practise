import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BigSort {
    //slower
    static String[] bigSorting(String[] unsorted) {

        return Arrays.stream(unsorted).map(BigInteger::new)
                .sorted().collect(Collectors.toList()).stream().map(Objects::toString).toArray(String[]::new);

    }

    //faster
    static String[] bigSorting2(String[] unsorted) {

        Arrays.sort(unsorted, (x, y) -> x.length() == y.length() ? x.compareTo(y)
                : Integer.compare(x.length(), y.length()));
        return unsorted;
    }


    public static void main(String[] args) {
        String[] s = {"1",
                "2",
                "100",
                "12303479849857341718340192371",
                "3084193741082937",
                "3084193741082938",
                "111",
                "200"};
        long start = System.currentTimeMillis();
        bigSorting(s);
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        long start2 = System.currentTimeMillis();
        bigSorting2(s);
        long end2 = System.currentTimeMillis();
        long elapsedTime2 = end2 - start2;
        System.out.println(elapsedTime);
        System.out.println(elapsedTime2);

    }
}
