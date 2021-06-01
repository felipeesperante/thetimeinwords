package br.com.nunesonline.thetimeinwords;

import java.util.Scanner;
import java.util.stream.Stream;

public class TheTimeInWordsApplication {

    public static void main(String[] args) {
        Scanner timeInput = new Scanner(System.in);
        while (true) {
            String[] time = timeInput.nextLine().split(":");
            int hour = Integer.parseInt(time[0].trim());
            int min = Integer.parseInt(time[1].trim());
            if (hour < 0 || hour >= 24) {
                System.out.println("Warning: Hour should be between 0 and 23");
            } else if (min < 0 || min >= 60) {
                System.out.println("Warning: Minutes should be between 0 and 59");
            } else {
                System.out.println(timeToWords(hour, min));
            }
        }
    }

    private static String timeToWords(int h, int m) {

        String[] v = Stream.of("zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
                "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
                "twenty six", "twenty seven", "twenty eight", "twenty nine").toArray(String[]::new);

        String time;

        if (m <= 30) {
            if (m == 0) {
                time = v[h] + " o' clock";
            } else if (m == 15) {
                time = "quarter past " + v[h];
            } else if (m == 30) {
                time = "half past " + v[h];
            } else if (m == 1) {
                time = v[m] + " minute past " + v[h];
            } else {
                time = v[m] + " minutes past " + v[h];
            }
        } else {
            if (h >= 23) {
                h = -1;
            }
            if (m == 45) {
                time = "quarter to " + v[h + 1];
            } else if (m == 59) {
                time = v[60 - m] + " minute to " + v[h + 1];
            } else {
                time = v[60 - m] + " minutes to " + v[h + 1];
            }
        }
        return time;
    }

}
