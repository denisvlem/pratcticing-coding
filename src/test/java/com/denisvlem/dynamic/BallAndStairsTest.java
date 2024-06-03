package com.denisvlem.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BallAndStairsTest {


    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 4),
                Arguments.of(4, 7),
                Arguments.of(5, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void testBallAndStairs(int givenStepNum, int expectedApproachesNum) {
        var solution = new BallAndStairs();
         assertThat(solution.calculateApproaches(givenStepNum)).isEqualTo(expectedApproachesNum);
    }

}