package com.denisvlem.tree.binary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InorderTraversalTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null)),
            List.of(1, 3, 2)
        ),
        Arguments.of(
            new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null),
                new TreeNode(5, new TreeNode(6, null, null), new TreeNode(7, null, null))),
                new TreeNode(3, null, new TreeNode(8, new TreeNode(9, null, null), null))),
            List.of(4, 2, 6, 5, 7, 1, 3, 9, 8)
        )
    );
  }

  private final InorderTraversal inorderTraversal = new InorderTraversal();

  @ParameterizedTest
  @MethodSource("getArgs")
  void inorderTraversal(TreeNode givenTree, List<Integer> expectedPath) {
    assertThat(inorderTraversal.inorderTraversal(givenTree)).asList().isEqualTo(expectedPath);
  }
}