package com.denisvlem.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubSequenceTest {

    @Test
    void testOneChar() {
        SubSequence subSequence = new SubSequence();

        assertThat(subSequence.isSubsequence("b", "c")).isFalse();
        assertThat(subSequence.isSubsequence("acb", "ahbgdc")).isFalse();
    }

}