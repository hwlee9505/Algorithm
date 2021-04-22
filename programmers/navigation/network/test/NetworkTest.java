package navigation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTest {

    @ParameterizedTest
    @MethodSource("getNetworkCountTestParameterGenerator")
    void getNetworkCount(int n, int[][] computers, int expected) {
        int actual = new Network().getNetworkCount(n, computers);
        assertEquals(actual, expected);
    }
    private static Stream<Arguments> getNetworkCountTestParameterGenerator() {
        return Stream.of(
            Arguments.of(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, 2),
            Arguments.of(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}, 1)
        );
    }
}