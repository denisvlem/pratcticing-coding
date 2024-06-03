package com.denisvlem.arrays;

import java.util.LinkedHashSet;

public class NoDuplicates {

    public static void main(String[] args) {

        var array = new char[] {'b', 'a', 'a', 'b', 'a', 'c', 'c','c'};

        var set = new LinkedHashSet<Character>();
        for (char ch : array) {
            set.add(ch);
        }
        set.forEach(System.out::println);
    }


}
