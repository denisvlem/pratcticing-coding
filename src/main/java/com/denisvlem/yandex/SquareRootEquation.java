package com.denisvlem.yandex;

import java.util.Scanner;

import static java.lang.System.*;

public class SquareRootEquation {

    public static void main(String[] args) {
        var scanner = new Scanner(in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        try {
            int result = calculateSquareRootEquation((float) a, (float) b, (float) c);
            out.println(result);
        } catch (IllegalArgumentException e) {
            out.println("NO SOLUTION");
        } catch (IllegalStateException e) {
            out.println("MANY SOLUTIONS");
        }
    }

    public static int calculateSquareRootEquation(Float a, Float b, Float c) {
        if (a == 0 && b * b == c) {
            throw new IllegalStateException();
        } else if (a == 0 && b == 0 && c == 0) {
            throw new IllegalStateException();
        } else if (c < 0) {
            throw new IllegalArgumentException("No solution");
        } else if (a == 0 && b < 0) {
            throw new IllegalArgumentException("No solution");
        }
        double x = (c * c - b) / a;

        if (a * x + b < 0) {
            throw new IllegalArgumentException("No solution");
        }
        if (Math.floor(x) == x) {
            return (int) x;
        } else {
            throw new IllegalArgumentException("No solution");
        }
    }
}
