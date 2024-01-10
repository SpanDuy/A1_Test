package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static Double factorial(Integer n) {
        Double sum = 0.0;
        for (int  i = 1; i <= n; i++) {
            Double subSum = 1.0;

            for (int j = i + 1; j <= n; j++) {
                subSum *= j;
            }

            sum += 1 / subSum;
        }

        return sum;
    }

    public static void main( String[] args ) {
        System.out.printf("%.6f", factorial(100));
    }
}
