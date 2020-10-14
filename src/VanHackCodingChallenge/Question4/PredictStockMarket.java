package VanHackCodingChallenge.Question4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class PredictStockMarket {




    public static void main(String[] args) {
        List<Integer> stock = new ArrayList<>();
        stock.add(5);
        stock.add(6);
        stock.add(8);
        stock.add(4);
        stock.add(9);
        stock.add(10);
        stock.add(8);
        stock.add(3);
        stock.add(6);
        stock.add(4);

        List<Integer> query = new ArrayList<>();
        query.add(6);
        query.add(5);
        query.add(4);

        predictAnswer(stock, query);
        System.out.println(predictAnswer(stock, query));

    }
    static int index = 0, value=0, k=0, j=0;
    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        //file the result list with -1
        List<Integer> result = new ArrayList<> (Collections.nCopies(queries.size(), -1));

        for (int i = 0; i < queries.size(); i++) {
            index = queries.get(i) - 1;
            value = stockData.get(index);

            j = index + 1;
            k = index - 1;
int count;
            while (j < stockData.size() - 1 || k > 1){
                if (k < 1) {
                    if (stockData.get(j) < value) {
                        result.set(i, j + 1);
                        break;
                    }
                }

                else if (j > stockData.size() - 1) {
                    if (stockData.get(k) < value) {
                        result.set(i, k + 1);
                        break;
                    }
                }

                else if (stockData.get(k) < value) {
                    result.set(i, k + 1);
                    break;
                }

                else if (stockData.get(j) < value) {
                    result.set(i, j + 1);
                    break;
                }

                j++;
                k--;
            }
        }
        return result;
    }
}


