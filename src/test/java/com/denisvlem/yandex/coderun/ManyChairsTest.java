package com.denisvlem.yandex.coderun;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManyChairsTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(2, 3, new Long[]{1L, 1L}, new Long[]{3L, 3L, 3L}, 4L),
            Arguments.of(6, 5, new Long[]{5L, 10L, 8L, 4L, 7L, 2L}, new Long[]{3L, 1L, 11L, 18L, 9L}, 27L),
            Arguments.of(1, 1, new Long[]{1L}, new Long[]{1L}, 0L),
            Arguments.of(1, 1, new Long[]{2L}, new Long[]{1L}, 0L),
            Arguments.of(1, 1, new Long[]{0L}, new Long[]{2L}, 2L),
            Arguments.of(1, 1, new Long[]{2L}, new Long[]{0L}, 0L),
            Arguments.of(1, 2, new Long[]{2L, 1L}, new Long[]{2L}, 1L),
            Arguments.of(1, 1, new Long[]{0L}, new Long[]{0L}, 0L),
            Arguments.of(5, 5, new Long[]{5L, 6L, 7L, 8L, 9L}, new Long[]{1L, 2L, 3L, 4L, 5L}, 0L),
            Arguments.of(2, 5, new Long[]{1L, 6L, 7L, 8L, 9L}, new Long[]{1_000_000_001L, 2L, 3L, 4L, 5L}, 1_000_000_000L)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void maxRevenue(int n, int m, Long[] sellers, Long[] buyers, long expectedRevenue) {
        assertThat(ManyChairs.maxRevenue(n, m, sellers, buyers)).isEqualTo(expectedRevenue);
    }
}