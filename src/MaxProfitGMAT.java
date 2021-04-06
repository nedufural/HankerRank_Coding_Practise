public class MaxProfitGMAT {

    public static int coffee_bean_max_profit(int[] coffee_bean_prices) {
        int tempPrice = coffee_bean_prices[0];
        int tempPrice2 = coffee_bean_prices[0];

        int[] prices = new int[coffee_bean_prices.length];
        int count = 1;
        int ascCount = 1;
        int descCount = 1;
        prices[count] = tempPrice;

        for (int i = 1; i < coffee_bean_prices.length; i++) {
            if (tempPrice < coffee_bean_prices[i]) {
                ascCount++;
                tempPrice = coffee_bean_prices[i];
                prices[count++] = coffee_bean_prices[i];
            } else if (tempPrice2 > coffee_bean_prices[i]) {
                descCount++;
                tempPrice2 = coffee_bean_prices[i];
            }
        }
        return getResult(coffee_bean_prices, prices, ascCount, descCount);
    }

    private static int getResult(int[] coffee_bean_prices, int[] prices, int ascCount, int descCount) {
        if (ascCount == coffee_bean_prices.length) {
            return maxProfitAscending(coffee_bean_prices);
        } else if (descCount == coffee_bean_prices.length) {
            return 0;
        } else {
            return maxProfitAscending(prices);
        }
    }

    public static int maxProfitAscending(int[] coffee_bean_prices) {
        int tempPrice = coffee_bean_prices[0];
        int maxProfit = 0;
        for (int i = 1; i < coffee_bean_prices.length; i++) {
            if (tempPrice < coffee_bean_prices[i]) {
                maxProfit = tempPrice - coffee_bean_prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] prices2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] prices3 = {8, 2, 5, 1, 6, 4};

        System.out.println(MaxProfitGMAT.coffee_bean_max_profit(prices));
        System.out.println(MaxProfitGMAT.coffee_bean_max_profit(prices2));
        System.out.println(MaxProfitGMAT.coffee_bean_max_profit(prices3));
    }
}
