package com.denisvlem.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumbers {

    private static final List<String> PHONE_BOOK = new LinkedList<>();

    public static void main(String... args) throws IOException {
        PHONE_BOOK.clear();

        var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        var seekedNumber = bufferedReader.readLine();
        for (int i = 0; i < 3; ++i) {
            PHONE_BOOK.add(formatNumber(bufferedReader.readLine()));
        }

        var formatSeekedNumber = formatNumber(seekedNumber);
        for (String number : PHONE_BOOK) {
            if (number.equals(formatSeekedNumber)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static String formatNumber(String number) {
        if (isIllegalInput(number)) {
            throw new IllegalArgumentException("Phone format is not supported");
        }

        var onlyNumbersFormatted = number.replaceAll("[()\\-\\s]*", "").replace("+7", "");
        if (onlyNumbersFormatted.length() == 11 && onlyNumbersFormatted.startsWith("8")) {
            onlyNumbersFormatted = onlyNumbersFormatted.substring(1);
        }

        return addCityCodeIfNeeded(onlyNumbersFormatted);
    }

    public static String addCityCodeIfNeeded(String onlyDigitsNumber) {
        if(onlyDigitsNumber.length() < 10) {
            return "495" + onlyDigitsNumber;
        } else {
            return onlyDigitsNumber;
        }
    }

    public static boolean isIllegalInput(String number) {
        return null == number || number.isEmpty();
    }
}
