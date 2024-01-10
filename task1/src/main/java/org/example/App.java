package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static Long ipv4ToInt(String ip) {
        return Arrays.stream(ip.split("\\."))
                .mapToLong(Long::parseLong)
                .reduce(0L, (result, currentOctet) -> result * 256 + currentOctet);
    }

    public static String intToIpv4(Long ipNumber) {
        StringBuilder ip = new StringBuilder("...");
        for (int i = 0; i < 4; i++) {
            ip.insert(3 - i, String.valueOf(ipNumber % 256L));
            ipNumber /= 256L;
        }

        return ip.toString();
    }

    public static void main(String[] args) {
        System.out.println(ipv4ToInt("128.32.10.0"));
        System.out.println(intToIpv4(255L));
    }
}
