import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StockPriceTest {
    @ParameterizedTest
    @MethodSource("getEachCheckTimeTestParameterGenerator")
    void getEachCheckTime(int[] prices, int[] expected) {
        int[] actual = new StockPrice().getEachCheckTime(prices);
        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }
    private static Stream<Arguments> getEachCheckTimeTestParameterGenerator() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 2, 3},  new int[]{4, 3, 1, 1, 0})
        );
    }
}