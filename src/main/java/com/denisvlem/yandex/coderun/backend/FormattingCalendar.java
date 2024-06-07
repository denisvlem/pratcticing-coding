package com.denisvlem.yandex.coderun.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class FormattingCalendar {

  public static void main(String[] args) throws IOException {

    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      var lineArray = reader.readLine().split(" ");
      var dayInMonth = Integer.parseInt(lineArray[0]);
      var firstDayOfMonth = lineArray[1];

      var days =
          Map.of(
              "Monday", 0,
              "Tuesday", 1,
              "Wednesday", 2,
              "Thursday", 3,
              "Friday", 4,
              "Saturday", 5,
              "Sunday", 6
          );

      int firstDay = days.get(firstDayOfMonth);
      int printed = 0;
      for (int i = 0; i < firstDay; i++) {
        System.out.print(".. ");
        printed++;
      }

      for (int i = 1; i <= dayInMonth; i++) {
        printed++;
        StringBuilder output = new StringBuilder(String.valueOf(i));
        if (i < 10) {
          output.insert(0, ".");
        }

        if (printed % 7 == 0) {
          System.out.println(output);
        } else {
          System.out.print(output + " ");
        }
      }
    }
  }

}
