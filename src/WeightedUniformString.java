import java.util.ArrayList;

public class WeightedUniformString {
    private static String[] weightedUniformStrings(String s, int[] queries) {

        char[] strToChar = s.toLowerCase().toCharArray();
        ArrayList<String> results = new ArrayList<>();
        ArrayList<Integer> alphabetNumList = new ArrayList<>();
        ArrayList<Integer> frequencyList = new ArrayList<>();

        for (char c : strToChar) {
            alphabetNumList.add(Character.getNumericValue(c) - 9);
        }
        computerTotalFrequencyOfAppearance(s, frequencyList);
        checkAndReturnResults(queries, results, alphabetNumList, frequencyList);
        return results.toArray(new String[0]);
    }

    /**
     * We have 2 lists 1st is for checking if the queries exist in the alphabets provided
     * the 2nd is for checking if the queries exist in alphabets frequency exist
     * */
    private static void checkAndReturnResults
            (int[] queries, ArrayList<String> results,
             ArrayList<Integer> alphabetNumList,
             ArrayList<Integer> frequencyList) {
        for (int query : queries) {
            if (alphabetNumList.contains(query) || frequencyList.contains(query)) {
                results.add("Yes");
            } else {
                results.add("No");
            }
        }
    }

    /**
     * We compute the frequency of alphabet in the  string here
     * */
    private static void computerTotalFrequencyOfAppearance
            (String s, ArrayList<Integer> frequencyMultiplier) {
        String[] splitResult;
        String frequencyOfOccurrence = getFrequencyOfOccurrence(s);
        for (String str : frequencyOfOccurrence.split("(?<=[0-9])(?=[a-zA-Z])")) {
            splitResult = str.split("(?=[0-9])", 2);

            frequencyMultiplier.add((Character.getNumericValue(splitResult[0].charAt(0)) - 9)
                    * (splitResult.length > 1 ? Integer.parseInt(splitResult[1]) : 1));

        }
    }

    static String getFrequencyOfOccurrence(String str) {
        char tempStr;
        int count = 1;
        char[] strSize = str.toCharArray();
        tempStr = strSize[0];
        StringBuilder frequencyOfOccurrence = new StringBuilder();
        frequencyOfOccurrence.append(strSize[0]);
        System.out.print(strSize[0]);

        for (int i = 1; i < strSize.length; i++) {
            if (tempStr == strSize[i]) {
                count++;
            } else {
                System.out.print(count);
                System.out.print(strSize[i]);
                frequencyOfOccurrence.append(count).append(strSize[i]);
                tempStr = strSize[i];
                count = 1;

            }
        }
        System.out.println(count);
        frequencyOfOccurrence.append(count);
        return frequencyOfOccurrence.toString();
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 12, 5, 9, 10};
        String[] s = weightedUniformStrings("abccdddeeaa", a);
        for (int i = 0; i < s.length; i++) {
          //  System.out.println(s[i]);
        }

    }
}
