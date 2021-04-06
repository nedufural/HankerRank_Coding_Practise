public class MyAtoi {
    public static void main(String[] args) {
       // myAtoi(" 9128347233");
        System.out.println(myAtoi("w -42"));
    }

    public static int myAtoi(String s) {
        String trimString = s.trim();

         if(trimString.contains("+") && (trimString.contains("-")) || trimString.isEmpty()){
             System.out.println(trimString);
            return 0;
        }
        try {
            if ((trimString.toCharArray()[0] == '-' || trimString.toCharArray()[0] == '+') && isANumber(trimString)) {
                System.out.println(trimString);
                return Integer.parseInt(trimString);
            }
            else if ((trimString.toCharArray()[0] == '-' || trimString.toCharArray()[0] == '+' && !isANumber(trimString)) && trimString.length() ==1) {
                return 0;
            }
            else if (!isANumber(trimString.toCharArray()[0] + "") && (trimString.toCharArray()[0] != '-' && trimString.toCharArray()[0] != '+')) {
                return 0;
            }
            else {
                //replaceAll("[^\\w-]+", " ")
                double result = Double.parseDouble(trimString.replaceAll("[a-zA-Z]",  "").trim());
                return (int) result;
            }
        } catch (NumberFormatException e) {
            return (int) bit32Convert(trimString);
        }
    }

    private static boolean isANumber(String num) {
        return num.chars().allMatch(Character::isDigit);
    }

    private static double bit32Convert(String num) {
        char firstChar = num.toCharArray()[0];
        if(firstChar == '-'){
            return Math.pow(-2, 31);
        } else  {
            return Math.pow(2, 31) - 1;
        }
    }
}
