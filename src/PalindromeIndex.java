public class PalindromeIndex {
    static int palindromeIndex(String s) {
        String temp;
        int stringLength = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s);

        for (int i = 0; i < stringLength; i++) {
            sb.deleteCharAt(i);
            System.out.println(sb);
            temp = sb.toString();
            if (temp.equals(new StringBuilder().append(temp).reverse().toString())) {
                return i;
            }
            else{
                return -1;
            }
        }
        return stringLength;
    }

    public static void main(String[] args) {
        System.out.println(palindromeIndex("aaab"));
    }
}
