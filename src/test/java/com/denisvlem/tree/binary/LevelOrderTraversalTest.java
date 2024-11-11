package com.denisvlem.tree.binary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LevelOrderTraversalTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            new TreeNode(1, null, null), List.of(List.of(1))
        ),
        Arguments.of(
            new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3,
                new TreeNode(4, null, null), new TreeNode(5, null, null))),
            List.of(List.of(1), List.of(2, 3), List.of(4, 5))
        ),
        Arguments.of(
            new TreeNode(1, new TreeNode(2,
                new TreeNode(3, new TreeNode(4, new TreeNode(5, null, null), null), null), null),
                null),
            List.of(List.of(1), List.of(2), List.of(3), List.of(4), List.of(5))
        ), Arguments.of(
            new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null),
                new TreeNode(3, null, new TreeNode(5, null, null))),
            List.of(List.of(1), List.of(2, 3), List.of(4, 5))
        ), Arguments.of(
            null,
            List.of()
        )
    );
  }

  private final LevelOrderTraversal solution = new LevelOrderTraversal();

  @ParameterizedTest
  @MethodSource("getArgs")
  void testLeverOrderTraversal(TreeNode tree, List<List<Integer>> expectedResult) {
    assertThat(solution.levelOrder(tree)).asList().isEqualTo(expectedResult);
  }
}