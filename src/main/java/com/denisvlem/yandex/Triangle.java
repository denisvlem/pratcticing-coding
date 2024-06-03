package com.denisvlem.yandex;

import java.util.Scanner;

public class Triangle {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);

    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();

    System.out.println(canBeATriangle(a, b, c) ? "YES" : "NO");
  }

  public static boolean canBeATriangle(int a, int b, int c) {
    return (a + b > c) && (a + c > b) && (b + c > a);
  }
}
