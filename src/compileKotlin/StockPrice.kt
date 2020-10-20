import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.FileReader
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*



val dateFormat = SimpleDateFormat("d-MMMM-yyyy")

class StockPrice(private val stocks: List<Stock>) : StockInterface {

    override fun openAndClosePrices(firstDate: String, lastDate: String, weekday: String): List<Stock> {

        val result = mutableListOf<Stock>()

        val minimumDate = dateFormat.parse("5-January-2000")!!
        val maximumDate = dateFormat.parse("1-January-2014")!!
        val weekday = try {
            DaysOfWeek.valueOf(weekday.toUpperCase())
        } catch (e: IllegalArgumentException) {
            print("Invalid parameter.")
            return result
        }
        var startDate = try {
            dateFormat.parse(firstDate)
        } catch (e: ParseException) {
            print("Invalid parameter.")
            return result
        }
        var endDate = try {
            dateFormat.parse(lastDate)
        } catch (e: ParseException) {
            print("Invalid parameter.")
            return result
        }
        if (endDate < startDate) {
            throw  InvalidParameters("Invalid parameter.")
        }
        if (startDate < minimumDate) {
            startDate = minimumDate
        }
        if (endDate > maximumDate) {
            endDate = maximumDate
        }
        for (element in stocks) {
            if (element.date!! > endDate) {
                break
            }
            if (element.date!! < startDate) {
                continue
            }
            if (getDaysOfWeek(element.date!!.day) == weekday) {
                element.print()
                result.add(element)
            }
        }
        if (result.size == 0) {
            print("Stock not found.")
        }
        return result
    }
}

enum class DaysOfWeek(val value: String) {
    SUNDAY("SUNDAY"),
    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY"),
    SATURDAY("SATURDAY"),
    INVALID("INVALID")
}
private fun getDaysOfWeek(day: Int): DaysOfWeek {
    return when (day) {
        0 -> DaysOfWeek.SUNDAY
        1 -> DaysOfWeek.MONDAY
        2 -> DaysOfWeek.TUESDAY
        3 -> DaysOfWeek.WEDNESDAY
        4 -> DaysOfWeek.THURSDAY
        5 -> DaysOfWeek.FRIDAY
        6 -> DaysOfWeek.SATURDAY
        else -> DaysOfWeek.INVALID
    }
}


class Stock {
    @SerializedName("date")
    @Expose
    var date: Date? = null

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

fun Stock.print() {
    println("${dateFormat.format(this.date)} ${this.open} ${this.close}")
}

interface StockInterface {
    fun openAndClosePrices(firstDate: String, lastDate: String, weekday: String): List<Stock>
}

class NoStockException(msg: String?) : java.lang.Exception(msg)

class InvalidParameters(message: String?) : java.lang.Exception(message)

fun main(args: Array<String>) {
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
        dateFormat.isLenient = false
        val gson = GsonBuilder().setDateFormat("d-MMMM-yyyy").create()
        val list = gson.fromJson(FileReader("data.json"), Array<Stock>::class.java).toList()
        val stockPrice = StockPrice(list)
        stockPrice.openAndClosePrices(firstDate!!, lastDate!!, weekDay!!)
    } catch (e: NoStockException) {
        e.printStackTrace()
    } catch (e: InvalidParameters) {
        e.printStackTrace()
    }
}