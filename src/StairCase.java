public class StairCase {

    static void staircase(int n) {
        for (int i = 1; i < n + 1; i++) {
            System.out.print(padRight("", n + 1 - i));
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

    static void staircase2(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++){
            builder.append(" ");}
        int j = 0;

        for (int i = 1; i <= n; i++) {
            builder.replace(builder.length() - i,
                    builder.length() - j, "#");
            System.out.println(builder);
            j++;
        }
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static void main(String[] args) {
        staircase(6);
        staircase2(6);
    }
}
