import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SherlockString {


    static String isValid(String s) {
        char[] c = s.toCharArray();
        for (char value : c) {
            if (!Character.isLowerCase(value)) {
                return "NO";
            }
        }
        if (s.toCharArray().length >= 1 && s.toCharArray().length <= (int) Math.pow(10, 5)) {
            int count = 0;
            final int[] arr = s.chars()
                    .map(x -> x - '0')
                    .toArray();
            List<Integer> freqList = checkFrequency(s);
            Set<Integer> mySet = new HashSet<>(freqList);
            for (Integer set : mySet) {
                if(mySet.size() == 1){
                    return "YES";
                }
                else if(mySet.size() > 1) {
                    if(Collections.frequency(freqList, set) > 1){
                        count ++;
                    }
                }
            }
            if (count > 1) {
                return "NO";
            } else {
                return "YES";
            }
        } else {
            return "NO";
        }
    }

    static List<Integer> checkFrequency(String arr) {
        HashMap<Character, Integer> freqHash = new HashMap<>();

        char[] c = arr.toCharArray();
        for (int i = 0; i < c.length; i++) {

            if (freqHash.containsKey(c[i])) {
                freqHash.put(arr.charAt(i), freqHash.get(c[i]) + 1);
            } else {
                freqHash.put(arr.charAt(i), 1);
            }
        }

        List<Integer> freqList = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : freqHash.entrySet()) {

            freqList.add(entry.getValue());
        }
        return freqList;
    }


    // Driver Code
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\admin\\Documents\\Spring_Java_Tutorials\\HankerRank_Coding_Practise\\src\\read.txt")));
            System.out.println(isValid(content)); //yes
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(isValid("aabbcd"));; // NO

        System.out.println(isValid("aabbccddeefghi"));  ; // NO

        System.out.println(isValid("abcdefghhgfedecba"));; // YES

        System.out.println(isValid("aabbcc"));; // YES

        System.out.println(isValid("abc")); // YES

        System.out.println(isValid("ab")); // YES

        /**
         * If there are 2 elements 1 element must have max of 1
         * else return NO else YES
         * if 1 element return YES
         * */
    }
}
