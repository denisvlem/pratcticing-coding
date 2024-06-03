package com.denisvlem.strings;

public class PalindromeTime {

    public int solution(int n, int m) {

        var nStr = Integer.toString(n);
        var mStr = Integer.toString(m);

        var tableSize = Math.max(nStr.length(), mStr.length());
        final var tableStringTemplate = "%0" + tableSize + "d";
        int palindromeCount = 0;

        for (int hour = 0; hour < n; ++hour) {

            var minutesTable = new StringBuilder(
                    String.format(tableStringTemplate, hour)
            ).reverse().toString();

            var minutesInt = Integer.parseInt(minutesTable);
            if (minutesInt < m) {
                palindromeCount++;
                System.out.println(hour + ":" + minutesTable);
            }
        }
        return palindromeCount;
    }
}
