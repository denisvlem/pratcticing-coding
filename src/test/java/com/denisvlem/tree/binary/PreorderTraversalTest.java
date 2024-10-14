package com.denisvlem.tree.binary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PreorderTraversalTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null)),
            List.of(1, 2, 3)
        ),
        Arguments.of(
            new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null),
                new TreeNode(5, new TreeNode(6, null, null), new TreeNode(7, null, null))),
                new TreeNode(3, null, new TreeNode(8, new TreeNode(9, null, null), null))),
            List.of(1, 2, 4, 5, 6, 7, 3, 8, 9)
        )
    );
  }

  private final PreorderTraversal preorderTraversal = new PreorderTraversal();

  @ParameterizedTest
  @MethodSource("getArgs")
  void testPreorderTraversal(TreeNode givenTree, List<Integer> expectedList) {
    assertThat(preorderTraversal.preorderTraversal(givenTree)).asList().isEqualTo(expectedList);
  }
}