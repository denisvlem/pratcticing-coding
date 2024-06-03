package com.denisvlem.yandex.coderun.backend;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterSetTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of("abba", Set.of('a', 'b'), 2),
            Arguments.of("ab", Set.of('a', 'b'), 2),
            Arguments.of("accb", Set.of('a', 'b', 'c'), 4),
            Arguments.of("ackb", Set.of('a', 'b', 'c'), 0),
            Arguments.of("acbb", Set.of('a', 'b', 'c'), 3),
            Arguments.of("aaaaaa", Set.of('b'), 0),
            Arguments.of("aaaaaab", Set.of('b'), 1),
            Arguments.of("a", Set.of('b'), 0),
            Arguments.of("a", Set.of('a'), 1),
            Arguments.of("baaaaa", Set.of('b'), 1),
            Arguments.of("aabcac", Set.of('a','b','c'), 3),
            Arguments.of("aaaaaaaaaaaaaaab", Set.of('a','b'), 2),
            Arguments.of("aaaaaaaaaaaaaaab", Set.of('a','b', 'c'), 0),
            Arguments.of("abbbbbbbbbbbbbbbcccccccc", Set.of('a','b','c'), "abbbbbbbbbbbbbbbc".length()),
            Arguments.of("bcccccccc", Set.of('a','b','c'), 0),
            Arguments.of("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz".chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet()), 26),
            Arguments.of("aaaaaaaabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz".chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet()), 26),
            Arguments.of("abcddefghijklmnopqrstuvwxyzz", "abcdefghijklmnopqrstuvwxyz".chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet()), 27),
            Arguments.of("abbcabc", "abc".chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet()), 3),
            Arguments.of("abbcabbbbcaabc", "abc".chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet()), 3),
            Arguments.of("abcabbc", "abc".chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet()), 3),
            Arguments.of("a", "abc".chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet()), 0),
            Arguments.of(
                Stream.generate(() -> "b").limit(100).reduce((left, right) -> left + right).orElseThrow() + "a",
                Set.of('a'),
                1
            ),
            Arguments.of(
              "abababab", Set.of('a'), 1
            ),
            Arguments.of(
                "b", Set.of('a', 'b'), 0
            ),
            Arguments.of("abbcab", Set.of('a', 'b', 'c'), 3),
            Arguments.of("abbсcabac", Set.of('a', 'b', 'c'), 3),
            Arguments.of("abccabbca", Set.of('a', 'b', 'c'), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void test(String input, Set<Character> set, int expectedMinSize) {
        assertThat(CharacterSet.findMinSubString(set, input)).isEqualTo(expectedMinSize);
    }
}