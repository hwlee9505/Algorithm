import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionDevelopmentTest {
    @ParameterizedTest
    @MethodSource("getEachDistributionTestParameterGenerator")
    void getEachDistribution (int[] progresses, int[] speeds, int[] expected) {
        int[] actual = new FunctionDevelopment().getEachDistribution(progresses, speeds);
        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }
    private static Stream<Arguments> getEachDistributionTestParameterGenerator () {
        return Stream.of(
                Arguments.of(new int[]{93, 30, 55}, new int[]{1, 30, 5}, new int[]{2, 1}),
                Arguments.of(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}, new int[]{1, 3, 2})
        );
    }
}