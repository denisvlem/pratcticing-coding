package com.denisvlem.yandex.coderun.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrivateKeyTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(10, 5, 2),
            Arguments.of(527, 9486, 4),
            Arguments.of(10, 11, 0),
            Arguments.of(5, 5, 1),
            Arguments.of(1000_000_000_000L, 5_000_000L , 4),
            Arguments.of(1000_000_000_000L, 1L , 4),
            Arguments.of(1000_000_000_000L/2 + 1, 1000_000_000_000L/2 - 1, 0)
        );
    }


    @ParameterizedTest
    @MethodSource("getArgs")
    void privateKey(long q, long p, long answer) {
        assertThat(PrivateKey.privateKey(q, p)).isEqualTo(answer);
    }
}