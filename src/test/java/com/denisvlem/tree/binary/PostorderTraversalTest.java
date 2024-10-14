package com.denisvlem.tree.binary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PostorderTraversalTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(null, List.of()),
        Arguments.of(new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null)),
            List.of(3, 2, 1)),
        Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null),
                new TreeNode(5, new TreeNode(6, null, null), new TreeNode(7, null, null))),
                new TreeNode(3, null, new TreeNode(8, new TreeNode(9, null, null), null))),
            List.of(4, 6, 7, 5, 2, 9, 8, 3, 1)
        ));
  }

  private final PostorderTraversal postorderTraversal = new PostorderTraversal();

  @ParameterizedTest
  @MethodSource("getArgs")
  void postOrderTraversal(TreeNode givenTree, List<Integer> expectedList) {
    assertThat(postorderTraversal.postorderTraversal(givenTree)).asList().isEqualTo(expectedList);
  }
}