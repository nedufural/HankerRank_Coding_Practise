package vanHackCodingChallenge.kotlin.Question3;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class StockPrice implements StockInterface {
    StockDatum[] stockData;

    public StockPrice(StockDatum[] stockData) {
        this.stockData = stockData;
    }

    public static StockDatum[] loadJsonFile() {
        Gson gson = new Gson();
        StockDatum[] stockData = new StockDatum[0];
        try {
            BufferedReader br = new BufferedReader(new FileReader("transaction.json"));
            stockData = gson.fromJson(br, StockDatum[].class);
            System.out.println(stockData.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockData;
    }

    public static LocalDate convertDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy", Locale.ENGLISH);
        return LocalDate.parse(date, formatter);
    }

    public static void main(String[] args) {
        StockDatum[] stockData = loadJsonFile();
        StockPrice stockPrice = new StockPrice(stockData);
        try {
            List<String> list = stockPrice.openAndCloseStockPrices("3-August-2020", "30-Sep-2020", "Tuesday");
            System.out.println(list.get(0));
        } catch (NoStockException | InvalidParameters e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> openAndCloseStockPrices(String firstDate, String lastDate, String weekDay)
            throws NoStockException, InvalidParameters {

        List<String> lis = new ArrayList<>();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("d-MMMM-yyyy", Locale.ENGLISH);
        LocalDate startDate;
        LocalDate endDate;

        boolean isValidFirstDate = isValidDate(firstDate);
        boolean isValidLastDate = isValidDate(lastDate);

        if (isValidLastDate && isValidFirstDate) {

            String convertedFirstDate = convertDay(convertMonths(firstDate));
            String convertedLastDate = convertDay(convertMonths(lastDate));
            endDate = LocalDate.parse(convertedLastDate, pattern);
            startDate = LocalDate.parse(convertedFirstDate, pattern);
        } else {
            throw new InvalidParameters("Invalid date format");
        }

        List<LocalDate> weekdayList = getNumberOfDaysInSpecTime(weekDay, startDate, endDate);
        checkStockAvailability(lis, weekdayList);
        isEmptyStockList(lis);
        return lis;
    }

    private void checkStockAvailability(List<String> lis, List<LocalDate> weekdayList) {
        for (int i = 0; i < stockData.length; i++) {
            if (convertDate(stockData[i].getDate()).isEqual(weekdayList.get(i))) {
                lis.add(stockData[i].getDate() + "   " + stockData[i].getOpen() + "  " + stockData[i].getClose());
            }
        }
    }

    private List<LocalDate> getNumberOfDaysInSpecTime(String weekDay, LocalDate startDate, LocalDate endDate) {
        List<LocalDate> weekdayList = new ArrayList<>();
        boolean reachedWeekDay = false;
        while (startDate.isBefore(endDate)) {
            if (startDate.getDayOfWeek() == DayOfWeek.valueOf(weekDay.toUpperCase())) {
                weekdayList.add(startDate);
                reachedWeekDay = true;
            }
            if (reachedWeekDay) {
                startDate = startDate.plusWeeks(1);
            } else {
                startDate = startDate.plusDays(1);
            }
        }
        return weekdayList;
    }

    public boolean isValidDate(String strDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d-MMMM-yyyy", Locale.ENGLISH);
        dateFormat.setLenient(false);
        try {
            Date javaDate = dateFormat.parse(strDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public void isEmptyStockList(List<String> stock) throws NoStockException {
        if (stock.isEmpty()) {
            throw new NoStockException("Stock not found");
        }
    }

    public String convertMonths(String date) {
        String caseValue = "";
        if (date.contains("January")) {
            caseValue = date.replace("January", "Jan");
        } else if (date.contains("February")) {
            caseValue = date.replace("February", "Feb");
        } else if (date.contains("March")) {
            caseValue = date.replace("March", "Mar");
        } else if (date.contains("April")) {
            caseValue = date.replace("April", "Apr");
        } else if (date.contains("June")) {
            caseValue = date.replace("June", "Jun");
        } else if (date.contains("July")) {
            caseValue = date.replace("July", "Jul");
        } else if (date.contains("August")) {
            caseValue = date.replace("August", "Aug");
        } else if (date.contains("September")) {
            caseValue = date.replace("September", "Sep");
        } else if (date.contains("October")) {
            caseValue = date.replace("October", "Oct");
        } else if (date.contains("November")) {
            caseValue = date.replace("November", "Nov");
        } else if (date.contains("December")) {
            caseValue = date.replace("December", "Dec");
        } else {
            return date;
        }
        return caseValue;
    }

    public String convertDay(String date) {
        int day = date.indexOf("-");
        String dayValue = "";
        if (day != -1) {
            dayValue = date.substring(0, day);
        }
        int arrSize = dayValue.toCharArray().length;
        if (arrSize < 2) {
            dayValue = date.replace(dayValue, "0" + dayValue);
        }
        else{
            return date;
        }
        return dayValue;
    }
}