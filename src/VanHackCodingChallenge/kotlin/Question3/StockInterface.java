package vanHackCodingChallenge.kotlin.Question3;

import java.time.DayOfWeek;
import java.util.List;

public interface StockInterface {
    List<String> openAndCloseStockPrices(String firstDate,String lastDate,String weekDay) throws NoStockException, InvalidParameters;
}
