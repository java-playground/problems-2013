/**
 *
 * BASE CLASS FOR BASIC FILE I/O
 * You can parse lines in the doTask() static function
 * Make sure to change the name of the class and the input file path
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Prob07 {

    static void doTask(String input) {

        String[] parts = input.split(", ");
        int firstCents = (int) Math.round(Double.parseDouble(parts[0]) * 100);
        int secondCents = (int) Math.round(Double.parseDouble(parts[1]) * 100);
        int diffCents = secondCents - firstCents;
        System.out.printf("$%.2f", new Double(diffCents).doubleValue() / 100);

        List<Integer> weights = new ArrayList<>();
        Collections.addAll(weights, 2000, 1000, 500, 100, 25, 10, 5, 1);
        List<String> types = new ArrayList<>();
        Collections.addAll(types, "TWENTY", "TEN", "FIVE", "ONE", "QUARTER", "DIME", "NICKEL", "PENNY");

        List<Integer> counts = new ArrayList<>();
        for(int weight : weights) {
            counts.add((int) Math.floor(diffCents / weight));
            diffCents %= weight;
            if(counts.get(counts.size() - 1) != 0) {
                System.out.printf(", %s=%d", types.get(counts.size() - 1), counts.get(counts.size() - 1));
            }
        }

        if(counts.stream().filter(e -> e > 0).count() == 0) {
            System.out.print(", NONE");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob07.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                doTask(line);
            }

        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
