import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TruckPassOverBridgeTest {
    @ParameterizedTest
    @MethodSource("getTakenTimeTestParameterGenerator")
    void getTakenTime (int bridge_length, int weight, int[] truck_weights, int expected) {
        int actual = new TruckPassOverBridge().getTakenTime(bridge_length, weight, truck_weights);
        assertEquals(actual, expected);
    }
    private static Stream<Arguments> getTakenTimeTestParameterGenerator () {
        return Stream.of(
                Arguments.of(2, 10, new int[]{7, 4, 5, 6}, 8),
                Arguments.of(100, 100, new int[]{10}, 101),
                Arguments.of(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 110)
        );
    }
}