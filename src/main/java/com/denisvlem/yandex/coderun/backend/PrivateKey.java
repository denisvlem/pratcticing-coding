package com.denisvlem.yandex.coderun.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrivateKey {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            var inputNumbers = Arrays.stream(reader.readLine().split(" "))
                .map(Long::parseLong)
                .toArray(Long[]::new);

            var x = inputNumbers[0];
            var y = inputNumbers[1];

            System.out.println(privateKey(x, y));
        }
    }

    public static long privateKey(long p, long q) {
        if (p == q) return 1;
        var r = gcd(p, q);
        p = p/r;
        q = q/r;
        if (r == 1 && q != 1 && p != 1) {
            return 0;
        }
        long count = 0;
        long multiplex = p * q;
        for (long i = 1; i * i <= multiplex; ++i) {
            if (multiplex % i == 0) {
                double gcd = gcd(i, multiplex / i);
                if ((gcd == q && multiplex / gcd == p) || (gcd == p && multiplex / gcd == q)) {
                    count += 2;
                }
            }
        }
        return count;
    }

    private static long gcd(long a, long b) {
        while (a > 0 && b > 0) {
            if (a >= b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return Math.max(a, b);
    }
}
