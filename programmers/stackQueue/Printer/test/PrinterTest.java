import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
    @ParameterizedTest
    @MethodSource("getPrintOrderTestParameterGenerator")
    void getPrintOrder (int[] priorities, int location, int expected) {
        int actual = new Printer().getPrintOrder(priorities, location);
        assertEquals(actual, expected);
    }
    private static Stream<Arguments> getPrintOrderTestParameterGenerator () {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3, 2}, 2, 1),
                Arguments.of(new int[]{1, 1, 9, 1, 1, 1}, 0, 5),
                Arguments.of(new int[]{4, 3, 3, 2}, 3, 4)
        );
    }
}