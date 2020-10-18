package compileKotlin

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.BufferedReader
import java.io.FileReader
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class StockPrice(stockData: Array<StockDatum?>?) : StockInterface {
    var stockData: Array<StockDatum?>?

    init {
        this.stockData = stockData
    }

    companion object Factory {
        fun loadJsonFile(): Array<StockDatum?>? {
            val gson = Gson()
            var stockData = arrayOfNulls<StockDatum>(0)
            try {
                val br = BufferedReader(FileReader("transaction.json"))
                stockData = gson.fromJson<Array<StockDatum?>>(br, Array<StockDatum>::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return stockData
        }
    }

    private fun convertDate(date: String?): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy", Locale.ENGLISH)
        return LocalDate.parse(date, formatter)
    }

    @Throws(NoStockException::class, InvalidParameters::class)
    override fun openAndCloseStockPrices(firstDate: String?, lastDate: String?, weekDay: String?): List<String?>? {
        val lis: MutableList<String> = ArrayList()
        val pattern = DateTimeFormatter.ofPattern("d-MMMM-yyyy", Locale.ENGLISH)
        val startDate: LocalDate
        val endDate: LocalDate
        val isValidFirstDate = isValidDate(firstDate)
        val isValidLastDate = isValidDate(lastDate)


        endDate = LocalDate.parse(lastDate, pattern)
        startDate = LocalDate.parse(firstDate, pattern)


        val weekdayList = getNumberOfDaysInSpecTime(weekDay!!, startDate, endDate)
        if (weekdayList.isNotEmpty()) {
            checkStockAvailability(lis, weekdayList)
        }
        isEmptyStockList(lis)
        return lis
    }

    private fun checkStockAvailability(lis: MutableList<String>, weekdayList: List<LocalDate>) {
        val pattern: DateTimeFormatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy", Locale.US)
        var dates: LocalDate
        for (i in stockData?.indices!!) {

            dates = LocalDate.parse(stockData!![i]!!.date, pattern)

            if (dates == (weekdayList[i])) {
                lis.add(stockData!![i]?.date + "   " + (stockData!![i]?.open) + "  " + (stockData!![i]?.close))
            }
        }
    }

    private fun getNumberOfDaysInSpecTime(weekDay: String, startDate: LocalDate, endDate: LocalDate): List<LocalDate> {
        var startDate = startDate
        val weekdayList: MutableList<LocalDate> = ArrayList()
        var reachedWeekDay = false
        while (startDate.isBefore(endDate)) {
            if (startDate.dayOfWeek == DayOfWeek.valueOf(weekDay.toUpperCase())) {
                weekdayList.add(startDate)
                reachedWeekDay = true
            }
            startDate = if (reachedWeekDay) {
                startDate.plusWeeks(1)
            } else {
                startDate.plusDays(1)
            }
        }
        return weekdayList
    }

    private fun isValidDate(strDate: String?): Boolean {
        val dateFormat = SimpleDateFormat("d-MMMM-yyyy", Locale.ENGLISH)
        dateFormat.isLenient = false
        return try {
            dateFormat.parse(strDate)
            true
        } catch (e: ParseException) {
            false
        }
    }

    @Throws(NoStockException::class)
    fun isEmptyStockList(stock: List<String>) {
        if (stock.isEmpty()) {
            throw NoStockException("Stock not found")
        }
    }

    private fun convertMonths(date: String): String {
        return when {
            date.contains("January") -> {
                date.replace("January", "Jan")
            }
            date.contains("February") -> {
                date.replace("February", "Feb")
            }
            date.contains("March") -> {
                date.replace("March", "Mar")
            }
            date.contains("April") -> {
                date.replace("April", "Apr")
            }
            date.contains("June") -> {
                date.replace("June", "Jun")
            }
            date.contains("July") -> {
                date.replace("July", "Jul")
            }
            date.contains("August") -> {
                date.replace("August", "Aug")
            }
            date.contains("September") -> {
                date.replace("September", "Sep")
            }
            date.contains("October") -> {
                date.replace("October", "Oct")
            }
            date.contains("November") -> {
                date.replace("November", "Nov")
            }
            date.contains("December") -> {
                date.replace("December", "Dec")
            }
            else -> {
                return date
            }
        }
    }

    fun convertDay(date: String): String? {
        val day = date.indexOf("-")
        var dayValue = ""
        if (day != -1) {
            dayValue = date.substring(0, day)
        }
        val arrSize = dayValue.toCharArray().size
        dayValue = if (arrSize < 2) {
            date.replace(dayValue, "0$dayValue")
        } else {
            return date
        }
        return dayValue
    }

    class StockDatum {
        @SerializedName("date")
        @Expose
        var date: String? = null

        @SerializedName("open")
        @Expose
        var open: Double? = null

        @SerializedName("high")
        @Expose
        var high: Double? = null

        @SerializedName("low")
        @Expose
        var low: Double? = null

        @SerializedName("close")
        @Expose
        var close: Double? = null

    }

    class NoStockException(msg: String?) : java.lang.Exception(msg)

    class InvalidParameters(message: String?) : java.lang.Exception(message)


}

interface StockInterface {
    @Throws(StockPrice.NoStockException::class, StockPrice.InvalidParameters::class)
    fun openAndCloseStockPrices(firstDate: String?, lastDate: String?, weekDay: String?): List<String?>?
}

fun main() {
    val stockData = StockPrice.loadJsonFile()
    val stockPrice = StockPrice(stockData)
    stockPrice.openAndCloseStockPrices("1-September-2020", "30-September-2020", "Tuesday")
    try {
        val `in` = Scanner(System.`in`)
        val firstDate: String?
        firstDate = try {
            `in`.nextLine()
        } catch (e: java.lang.Exception) {
            null
        }

        val lastDate: String?
        lastDate = try {
            `in`.nextLine()
        } catch (e: java.lang.Exception) {
            null
        }

        val weekDay: String?
        weekDay = try {
            `in`.nextLine()
        } catch (e: java.lang.Exception) {
            null
        }
        stockPrice.openAndCloseStockPrices(firstDate, lastDate, weekDay)
    } catch (e: StockPrice.NoStockException) {
        e.printStackTrace()
    } catch (e: StockPrice.InvalidParameters) {
        e.printStackTrace()
    }
}


