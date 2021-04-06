import jdk.jfr.Unsigned;

import java.util.List;

public class SubstringConcatenation {

    public static void main(String[] args) {
        int count = 0;
        String text = "wordgoodgoodgoodbestword";
        String word = "word";
        String word2 = "good";
        String word3 = "best";
        String word4 = "good";
        for (int i = -1; (i = text.indexOf(word, i + 1)) != -1; i++) {
            System.out.print("word : "+i +" ");
            System.out.println(i+word.length() - 1);
        }
        for (int i = -1; (i = text.indexOf(word2, i + 1)) != -1; i++) {
            System.out.print("good : "+i +" ");
            System.out.println(i+word2.length() - 1);
        }
        for (int i = -1; (i = text.indexOf(word3, i + 1)) != -1; i++) {
            System.out.print("best : "+i +" ");
            System.out.println(i+word3.length() - 1);
        }
          
        //System.out.println(InstrumentationAgent.getObjectSize(object));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        return null;
    }
}
