import java.util.Date;

public class Kangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        for (int i = 0; i < 10000; i++) {
            x1 = x1 + v1;
            x2 = x2 + v2;

            if(x1 == x2){
              return "YES";
            }
        }
        return "NO";
    }

    static String kangaroo2(int x1, int v1, int x2, int v2) {
		if (v1 > v2) {

        int remainder = (x1 - x2) % (v2 - v1);

        if (remainder == 0) {
            return "YES";
        }
    }
		return "NO";

}
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(startTime);
        System.out.println(kangaroo(0 ,3, 4 , 2));
        long endTime = System.nanoTime();
        System.out.println(endTime);
        long startTime1 = System.nanoTime();
        System.out.println(startTime1);
        System.out.println(kangaroo2(0 ,3, 4 , 2));
        long endTime1 = System.nanoTime();
        System.out.println(endTime1);




    }
}
