package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static Double factorial(Integer n) {
        Double sum = 1.0;
        Double subSum = 1.0;
        for (int  i = n; i > 1; i--) {
            subSum /= i;

            sum += subSum;
        }

        return sum;
    }

    public static void main( String[] args ) {
        System.out.printf("%.6f", factorial(6));
    }
}

// n = 6;  1/23456 + 1/3456 + 1/456 + 1/56 + 1/6 + 1