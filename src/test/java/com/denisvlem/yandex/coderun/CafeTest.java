package com.denisvlem.yandex.coderun;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class CafeTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
//            Arguments.of(6, new int[]{35, 102, 81, 34, 105, 97}, 276, 2, 0),
//            Arguments.of(5, new int[]{35, 40, 101, 59, 63}, 235, 1, 0),
            Arguments.of(5, new int[]{1, 1, 1, 1, 2}, 6, 0, 0),
//            Arguments.of(5, new int[]{101, 102, 103, 104, 105}, 306, 2, 1),
//            Arguments.of(5, new int[]{105, 104, 103, 102, 101}, 309, 2, 1),
            Arguments.of(1, new int[]{105}, 105, 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void testCafe(int givenN,
                  int[] givenPrices,
                  int expectedMinPrice,
                  int expectedCouponSpent,
                  int expectedCouponRest) {

        var result = Cafe.calculate(givenN, givenPrices);
        assertThat(result.minPrice).isEqualTo(expectedMinPrice);
        assertThat(result.couponSpent).isEqualTo(expectedCouponSpent);
        assertThat(result.couponRest).isEqualTo(expectedCouponRest);
    }
}