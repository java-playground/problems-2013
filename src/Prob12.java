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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob12 {

    static Map<String, Integer> tagMap = new LinkedHashMap<>();
    static Pattern tagPattern = Pattern.compile("<([^>/]+)>");

    static void doTask(String input) {

        Matcher tagMatcher = tagPattern.matcher(input);
        while(tagMatcher.find()) {

            tagMap.put(tagMatcher.group(1), tagMap.getOrDefault(tagMatcher.group(1), 0) + 1);

        }

    }

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob12.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while((line = reader.readLine()) != null) {
                doTask(line);
            }

            tagMap.entrySet().forEach(entry -> {
                System.out.printf("%s %d%n", entry.getKey(), entry.getValue());
            });

        } catch(IOException e) { System.err.println(e); }

    }

}
