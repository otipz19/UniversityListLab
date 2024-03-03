package tests.model.utils;

import main.model.utils.sorting.comparators.NamesLocaleComparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NamesLocaleComparatorTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    public void compare1(String first, String second, int expected){
        int actual = NamesLocaleComparator.compare(first, second);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideArguments(){
        return Stream.of(
                Arguments.of("и", "ї", -1),
                Arguments.of("и", "і", -1),
                Arguments.of("й", "ї", 1),
                Arguments.of("й", "і", 1),
                Arguments.of("а", "ї", -1),
                Arguments.of("а", "і", -1),
                Arguments.of("я", "ї", 1),
                Arguments.of("я", "і", 1)
        );
    }
}