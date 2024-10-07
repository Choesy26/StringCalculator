package org.example;

import java.util.regex.Matcher; // 특정 문자열에서 패턴 찾아내기
import java.util.regex.Pattern; // 객체를 사용해 문자열 검색하고 매칭

public class StringCalculator {

    public int add(String text) {

        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1); // 커스텀 구분자 추가
            return m.group(2).split(customDelimeter); // \n 이후 문자열을 커팅
        }
        return text.split("[,;]");
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}