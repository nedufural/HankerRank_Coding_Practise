import java.util.Arrays;

public class Anagram {
    private static int anagram(String s) {
        int checkDivisibleBy2 = s.toCharArray().length % 2;
        String s1 = s.substring(0, (s.length() / 2));
        String s2 = s.substring((s.length() / 2));
        char[] c1;
        char[] c2;
        if (checkDivisibleBy2 == 0) {
            c1 = s1.toCharArray();
            c2 = s2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            int numberOfMoves = 0;
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] != c2[i] || !((new String(c2).contains(c1[i] + "")))) {
                    //System.out.println(c1[i]);
                    numberOfMoves++;
                }
            }
            return numberOfMoves;

        } else {
            return -1;
        }
    }

    private static int anagram2(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }
        int result = 0;
        int[] c1 = new int[26];
        for (int i = 0; i < s.length() / 2; i++)
            c1[s.charAt(i) - 97]++;
        for (int i = s.length() / 2; i < s.length(); i++)
            c1[s.charAt(i) - 97]--;
        for (int val : c1) {
            result += Math.abs(val);
        }
        return result / 2;
    }

    public static void main(String[] args) {
        System.out.println(anagram("xyyx"));
    }
}
