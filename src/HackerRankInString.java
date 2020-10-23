public class HackerRankInString {

    // Complete the hackerrankInString function below.
    private static final String resultNO = "NO";
    private static final String resultYES = "YES";
    static String hackerrankInString(String s) {
        int countOccurrences = 0;
        char[] hackRankStringToChar = s.toCharArray();
        char[] hackerrank = "hackerrank".toCharArray();


        if (s.length() < hackerrank.length) {
            return resultNO;
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                if (countOccurrences < hackerrank.length && hackRankStringToChar[i] == hackerrank[countOccurrences]) {
                    countOccurrences++;
                }
            }
            if (countOccurrences == hackerrank.length) {
                return resultYES;
            } else {
                return resultNO;
            }
        }
    }
}
