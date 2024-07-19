import java.util.*;

public class BestTimeToBuyAndSellStock {

    // Brute Force

    public int brute (int[] prices) {
        int n = prices.length;
        int max_profit = 0;
        for(int i = 0; i < n-1; i++) {
            int buy_price = prices[i];
            for(int j = i + 1; j < n; j++) {
                int profit = prices[j] - buy_price;
                max_profit = Math.max(max_profit, profit);
            }
        }
        return max_profit;
    }

    // Better Approach

    public int better(int[] prices) {
        int n = prices.length;
        int max_profit = 0;
        // Using Tree Map (Sorted Order)
        TreeMap <Integer, Integer> tp = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            tp.put(prices[i], i);
            Integer min_price = tp.firstKey();
            if(tp.get(min_price) < i) {
                int profit = prices[i] - min_price;
                max_profit = Math.max(max_profit, profit);
            }
        } 
        return max_profit;
    }

    // Optimized Approach

    public int optimal(int[] prices) {
        int n = prices.length;
        int max_profit = 0;
        int buy_price = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(buy_price > prices[i]) {
                buy_price = prices[i];
            }
            else {
                int profit = prices[i] - buy_price;
                max_profit = Math.max(profit, max_profit);
            }
        }
        return max_profit;
    }
}