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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Prob06 {

    static Map<String, Integer> scores = new HashMap<>();

    static void doTask(String input) {

        String[] parts = input.split("\\:");
        String name = parts[0];
        AtomicInteger score = new AtomicInteger(0);
        Arrays.stream(parts[1].split(","))
                .forEach(e -> score.set(score.get() + Integer.parseInt(e)));
        scores.put(name, score.get());

    }

    public static void main(String[] args) {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob06.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                doTask(line);
            }

            List<String> names = new ArrayList<>(scores.keySet());
            names.sort((a, b) -> scores.get(a) - scores.get(b));
            System.out.printf("FIRST: %s%nSECOND: %s%nTHIRD: %s%nLAST: %s%n", names.get(0), names.get(1), names.get(2), names.get(names.size()-1));

        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
