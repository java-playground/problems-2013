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
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Prob04 {

    static void doTask(String input) {

        System.out.println(String.join(",", Arrays.stream(input.split(","))
            .sorted(Comparator.comparingInt(Integer::parseInt))
            .toArray(String[]::new)
        ));

    }

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob04.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while((line = reader.readLine()) != null) {
                doTask(line);
            }

        } catch(IOException e) { System.err.println(e); }

    }

}
