package com.denisvlem.dynamic;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {

    private final Deque<String> strings = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        strings.clear();
        generateRecursive(new StringBuilder(), '(', 1, 0, n);
        return new ArrayList<>(strings);
    }

    private void generateRecursive(StringBuilder builder, char parent, int addedOpen, int addedClose, int n) {
        builder.append(parent);

        if (addedOpen < n) {
           generateRecursive(builder, '(', addedOpen + 1, addedClose, n);
        }

        if (addedClose < addedOpen) {
            generateRecursive(builder, ')', addedOpen, addedClose + 1, n);
        }

        if (addedClose == n) {
            strings.push(builder.toString());
        }
        builder.deleteCharAt(addedOpen + addedClose - 1);
    }
}
