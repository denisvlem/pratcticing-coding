package com.denisvlem.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotateImageTest {

    private static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(
                new int[][]{},
                new int[][]{}
            ),
            Arguments.of(
                new int[][]{
                    {1}
                },
                new int[][]{
                    {1}
                }
            ),
            Arguments.of(
                new int[][]{
                    {1, 2},
                    {3, 4},
                },
                new int[][]{
                    {3, 1},
                    {4, 2}
                }
            ),
            Arguments.of(
                new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
                },
                new int[][]{
                    {7, 4, 1},
                    {8, 5, 2},
                    {9, 6, 3}
                }
            ),
            Arguments.of(
                new int[][]{
                    {0, 1, 2, 3, 4, 5, 6},
                    {7, 8, 9, 10, 11, 12, 13},
                    {14, 15, 16, 17, 18, 19, 20},
                    {21, 22, 23, 24, 25, 26, 27},
                    {28, 29, 30, 31, 32, 33, 34},
                    {35, 36, 37, 38, 39, 40, 41},
                    {42, 43, 44, 45, 46, 47, 48}
                },
                new int[][]{
                    {42, 35, 28, 21, 14, 7, 0},
                    {43, 36, 29, 22, 15, 8, 1},
                    {44, 37, 30, 23, 16, 9, 2},
                    {45, 38, 31, 24, 17, 10, 3},
                    {46, 39, 32, 25, 18, 11, 4},
                    {47, 40, 33, 26, 19, 12, 5},
                    {48, 41, 34, 27, 20, 13, 6}
                }
            )
        );
    }

    private final RotateImage solution = new RotateImage();


    @MethodSource("getArgs")
    @ParameterizedTest
    void testSolution(int[][] given, int[][] expected) {
        solution.rotate(given);

        assertThat(given).isDeepEqualTo(expected);
    }

}