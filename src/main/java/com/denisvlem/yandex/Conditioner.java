package com.denisvlem.yandex;

import java.util.Scanner;

public class Conditioner {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    String temps = scanner.nextLine();
    String regime = scanner.nextLine();

    var tRoom = Integer.parseInt(temps.substring(0, temps.indexOf(" ")));
    var tCond = Integer.parseInt(temps.substring(temps.indexOf(" ") + 1));

    System.out.println(calculateTemperature(tRoom, tCond, regime));
  }

  private static int calculateTemperature(int tRoom, int tCond, String regime) {
    if ("heat".equals(regime)) {
      return Math.max(tRoom, tCond);
    } else if ("freeze".equals(regime)) {
      return Math.min(tRoom, tCond);
    } else if("auto".equals(regime)) {
      return tCond;
    } else if ("fan".equals(regime)) {
      return tRoom;
    } else {
      throw new IllegalArgumentException("Unexpected regime: " + regime);
    }
  }
}
