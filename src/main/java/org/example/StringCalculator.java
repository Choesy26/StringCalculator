package org.example;

public class StringCalculator {

    int add(String text) {

        if (text == null || text.isEmpty())
            return 0;

        int number = 0;
        int begin = 0;
        int end = 0;
        String[] numbers;

        try {
            number = Integer.parseInt(text);

            if (number < 0) {
                throw new RuntimeException();
            }
            return number;
        } catch (NumberFormatException e) {
        }

        if(text.startsWith("//")) {
            String newToken = "";
            begin = text.indexOf("//") + 2;
            end = text.indexOf("\n");
            newToken = text.substring(begin, end);
            text = text.substring(end + 1);
            numbers = text.split(newToken);
        }

        numbers = text.split("[,;]");
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }

        return sum;

    }
}