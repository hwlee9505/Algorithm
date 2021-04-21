import java.util.Arrays;

public class StockPrice {

    /**
     *
     * @param prices 초 단위로 기록된 주식가격이 담긴 배열 (1 <= n <= 10,000)
     * @return 갹각 언제 떨어지는지 몇 초까지 확인해야하는지
     */
    public int[] getEachCheckTime(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return (answer);
    }
}