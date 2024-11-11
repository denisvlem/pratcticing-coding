package com.denisvlem.tree.binary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortedArrayToBSTTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(new int[]{1, 2}, new TreeNode(2, new TreeNode(1, null, null), null)),
        Arguments.of(new int[]{1, 2, 3},
            new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null))),
        Arguments.of(new int[]{-10, -3, 0, 5, 9},
            new TreeNode(0,
                new TreeNode(-3, new TreeNode(-10), null),
                new TreeNode(9, new TreeNode(5), null))
        )
    );
  }

  private final SortedArrayToBST solution = new SortedArrayToBST();

  @MethodSource("getArgs")
  @ParameterizedTest
  void sortedArrayToBST(int[] givenNums, TreeNode expectedTreeRoot) {
    assertThat(solution.sortedArrayToBST(givenNums)).usingRecursiveComparison()
        .isEqualTo(expectedTreeRoot);
  }
}