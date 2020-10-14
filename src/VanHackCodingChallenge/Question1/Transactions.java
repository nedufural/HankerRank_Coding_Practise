package VanHackCodingChallenge.Question1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transactions {




    public static void main(String[] args) {
        System.out.println(getTransactions(2,8,5,50));

    }

    static List<String> ipList = new ArrayList<>();
    static List<String> amountList = new ArrayList<>();
    static List<String> idList = new ArrayList<>();

    public static String performGETRequest(String tnxURL, int userId, int page) {
        String requestResults = null;
        try {
            //perform the GET Request
            URL url = new URL(tnxURL + userId + "&page=" + page);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            //retrieve and convert results to string
            StringBuilder content;
            try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = input.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            } finally {
                //close network connection
                connection.disconnect();
            }
            requestResults = content.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return requestResults;
    }

    public static int getTransactions(int userId, int locationId, int netStart, int netEnd) {
        String requestResults = performGETRequest(" https://jsonmock.hackerrank.com/api/transactions/search?userId=", userId, 1);
        decodingJsonFromRequestResult(requestResults, userId);
        return sumAmountOfTransactions(locationId, netStart, netEnd);
    }


    private static void decodingJsonFromRequestResult(String getRate, int userId) {
        Matcher pagesMatcher;

        //Patterns for striping the GET_Result string
        String pattern1 = "\"location\":\"id\":";
        String pattern2 = ",\"address\"";
        String pattern3 = ",\"ip\":\"";
        String pattern4 = "\"";
        String pattern5 = ",\"amount\":\"$";
        String pattern6 = "\",\"location";
        String pagesPatternBegin = "\"total_pages\":";
        String pagesPatternEnd = ",";

        //Perform String Patterning
        //Get location ID
        Pattern idPattern = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
        //Get IP
        Pattern ipPattern = Pattern.compile(Pattern.quote(pattern3) + "(.*?)" + Pattern.quote(pattern4));
        //Get Amount of money
        Pattern amountPattern = Pattern.compile(Pattern.quote(pattern5) + "(.*?)" + Pattern.quote(pattern6));
        //Get number of pages (GET request pages) to Iterate
        Pattern finalPagesPattern = Pattern.compile(Pattern.quote(pagesPatternBegin) + "(.*?)" + Pattern.quote(pagesPatternEnd));

        pagesMatcher = finalPagesPattern.matcher(getRate);
        int numberOfPages = 0;
        while (pagesMatcher.find()) {
            numberOfPages = Integer.parseInt(pagesMatcher.group(1));
        }
        addDecodedDataToLists(idPattern, ipPattern, amountPattern, numberOfPages, userId);
    }

    private static void addDecodedDataToLists(Pattern idPattern, Pattern ipPattern, Pattern amountPattern,
                                              int numberOfPages, int userId) {
        String result;
        Matcher idMatcher;
        String[] splits;
        Matcher amountMatcher;
        Matcher ipMatcher;
        for (int i = 1; i <= numberOfPages; i++) {
            result = performGETRequest(" https://jsonmock.hackerrank.com/api/transactions/search?userId=", userId, i);

            String text = formattingTheJsonString(result);

            idMatcher = idPattern.matcher(text);
            while (idMatcher.find()) {
                idList.add(idMatcher.group(1));
            }
            ipMatcher = ipPattern.matcher(result);
            while (ipMatcher.find()) {
                splits = ipMatcher.group(1).split("\\.");
                ipList.add(splits[0]);
            }
            amountMatcher = amountPattern.matcher(text);
            while (amountMatcher.find()) {
                amountList.add(amountMatcher.group(1));
            }
        }
    }
    private static int sumAmountOfTransactions(int locationId, int netStart, int netEnd) {
        double sum = 0;
        for (int i = 0; i < idList.size(); i++) {

            if (idList.get(i).equals(String.valueOf(locationId)) && (Integer.parseInt(ipList.get(i)) >= netStart && Integer.parseInt(ipList.get(i)) <= netEnd)) {
                sum += Double.parseDouble(amountList.get(i).replace(",", ""));
            }
        }
        return (int) Math.round(sum);
    }

    private static String formattingTheJsonString(String result) {
        String[] arrOfStr = result.split("\"data\":", 0);
        String newString = arrOfStr[1].replaceAll("}", "");
        return newString.replaceAll("\\{", "");
    }



}


