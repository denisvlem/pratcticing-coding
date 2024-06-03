package com.denisvlem.yandex.coderun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LCSTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(new Integer[]{1, 1, 1}, new Integer[]{1, 1, 1}, List.of(1, 1, 1)),
            Arguments.of(new Integer[]{1}, new Integer[]{1}, List.of(1)),
            Arguments.of(new Integer[]{0}, new Integer[]{1}, Collections.emptyList()),
            Arguments.of(new Integer[]{}, new Integer[]{}, Collections.emptyList()),
            Arguments.of(new Integer[]{1,2,1}, new Integer[]{1,1}, List.of(1,1)),
            Arguments.of(new Integer[]{1,2,1}, new Integer[]{1,3,1}, List.of(1,1)),
            Arguments.of(new Integer[]{1,2,2,2,2,2,1}, new Integer[]{1,33,3,3,3,3,22,2,2,22,2,2,2,2,1}, List.of(1,2,2,2,2,2,1)),
            Arguments.of(new Integer[]{1,1,1,1,1,1,1,1}, new Integer[]{1}, List.of(1)),
            Arguments.of(new Integer[]{1,1,1,1,2,2,2,2,2}, new Integer[]{2,2,2,2,1,1,1,1}, List.of(2,2,2,2)),
            Arguments.of(new Integer[]{1,2,3}, new Integer[]{2,3,1}, List.of(2,3)),
            Arguments.of(new Integer[]{1,2,3,4,5,6}, new Integer[]{1,1,2,2,3,3,4,4,5,5,6,6}, List.of(1,2,3,4,5,6)),
            Arguments.of(new Integer[]{1,2,3,4,5,6,7}, new Integer[]{5,6,7,1,2,3}, List.of(5,6,7))
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void longestCommonSubsequence(Integer[] givenSeq1, Integer[] givenSeq2, List<Integer> expectedResult) {

        var solution = new LCS(givenSeq1, givenSeq2);
        assertThat(solution.longestCommonSubsequence()).asList().isEqualTo(expectedResult);
    }
}