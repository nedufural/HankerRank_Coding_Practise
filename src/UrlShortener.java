import java.io.IOException;


public class UrlShortener {

    public static String encode(int id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(CommonConstants.ALPHANUMERICS.charAt(id % CommonConstants.BASE));
            id /= CommonConstants.BASE;
        }
        return sb.reverse().toString();
    }

    public static int decode(String str) {
        int id = 0;
        for (int i = 0; i < str.length(); i++)
            id = id * CommonConstants.BASE + CommonConstants.ALPHANUMERICS.indexOf(str.charAt(i));
        return id;
    }

    public static void main(String[] args) throws IOException {
        int n = 633675296;
        String shorturl = encode(n);
        System.out.println("1. Generated short url is " + shorturl);
        System.out.printf("Id from url is %s" ,decode("https://www.google.com"));
    }
}

class CommonConstants {
    public static final String ALPHANUMERICS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int BASE = ALPHANUMERICS.length();
}
