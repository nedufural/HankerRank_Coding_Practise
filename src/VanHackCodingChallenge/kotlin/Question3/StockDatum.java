package VanHackCodingChallenge.kotlin.Question3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockDatum {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("open")
    @Expose
    private Double open;
    @SerializedName("high")
    @Expose
    private Double high;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("close")
    @Expose
    private Double close;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

}