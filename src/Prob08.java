/**
 *
 * BASE CLASS FOR BASIC FILE I/O
 * You can parse lines in the doTask() static function
 * Make sure to change the name of the class and the input file path
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Prob08 {

    static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> BigInteger.valueOf(i))
                .reduce(BigInteger.valueOf(1), (a, b) -> a.multiply(b));
    }

    static String combination(int n, int r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n-r))).toString();
    }

    static void doTask(String input) {

        String[] parts = input.split(" ");
        System.out.println(combination(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));

    }

    public static void main(String[] args) {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob08.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                doTask(line);
            }

        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
