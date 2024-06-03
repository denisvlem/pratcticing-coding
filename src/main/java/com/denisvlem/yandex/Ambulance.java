package com.denisvlem.yandex;

import java.util.Scanner;

public class Ambulance {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int k1 = scanner.nextInt();
        int m = scanner.nextInt();
        int k2 = scanner.nextInt();
        int p2 = scanner.nextInt();
        int n2 = scanner.nextInt();

        int pNtoN2 = (p2 - 1) * m + n2; //количество блоков до квартиры k2, влкючая тот на котором она
        int pn = pNtoN2/k2;

        int pn1 = k1/pn;
        int p1 = pn1/m;
    }
}
