package navigation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TargetNumberTest {

    @ParameterizedTest
    @MethodSource("getNumberOfCasesTestPrarmeterGenerator")
    void getNumberOfCases (int[] numbers, int target, int expected) {
        int actual = new TargetNumber().getNumberOfCases(numbers, target);
        assertEquals(actual, expected);
    }
    private static Stream<Arguments> getNumberOfCasesTestPrarmeterGenerator() {
        return Stream.of(
                Arguments.of(new int[] {1, 1, 1, 1, 1}, 3, 5),
                Arguments.of(new int[] {1, 2, 1, 2}, 2, 3),
                Arguments.of(new int[] {1, 2, 1, 2}, 6, 1)
        );
    }
}