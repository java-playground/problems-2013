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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Prob03 {

    static Map<String, Integer> filenames = new LinkedHashMap<>();

    static void doTask(String input) {

        String[] parts = input.split("\\.");
        String extension = parts[parts.length - 1];
        filenames.put(extension, filenames.getOrDefault(extension, 0) + 1);

    }

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob03.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while((line = reader.readLine()) != null) {
                doTask(line);
            }

            filenames.keySet().forEach(extension -> System.out.printf("%s %d%n", extension, filenames.get(extension)));

        } catch(IOException e) { System.err.println(e); }

    }

}
