public class CamelCase {

    static int checkCamelCase(String camelString){
        int countWord = 1;
        char [] camelChar = camelString.toCharArray();

        for (int i = 0; i < camelChar.length; i++) {
            if( Character.isUpperCase(camelChar[i])){
                countWord++;
            }
        }
        return countWord;
    }

    public static void main(String[] args) {
        System.out.println(checkCamelCase("saveChangesInTheEditor"));
    }
}
