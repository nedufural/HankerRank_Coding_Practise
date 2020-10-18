public class CamelCase {

   private static int checkCamelCase(String camelString){
        int countWord = 1;
        char [] camelChar = camelString.toCharArray();

        for (char c : camelChar) {
            if (Character.isUpperCase(c)) {
                countWord++;
            }
        }
        return countWord;
    }

    public static void main(String[] args) {
        System.out.println(checkCamelCase("saveChangesInTheEditor"));
    }
}
