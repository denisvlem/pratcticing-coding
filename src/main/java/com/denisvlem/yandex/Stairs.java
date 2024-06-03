package com.denisvlem.yandex;

import java.util.Scanner;

public class Stairs {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    final int n = scanner.nextInt();

    System.out.println(new Stairs().maxStairHeight(n));
  }

  public int maxStairHeight(int n) {
    int cubesUsed = 0;
    int height = 0;
    while(cubesUsed <= n) {
      cubesUsed += height;
      if(cubesUsed > n || cubesUsed < 0) {
        return height - 1;
      } else {
        height++;
      }
    }
    return 0;
  }

}
