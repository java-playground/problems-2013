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
import java.util.Collections;
import java.util.List;

public class Prob02 {

    static void doTask(String input) {

        List<String> letters = Arrays.asList(input.split(""));
        Collections.reverse(letters);
        System.out.println(String.join("", letters));

    }

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob02.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while((line = reader.readLine()) != null) {
                doTask(line);
            }

        } catch(IOException e) { System.err.println(e); }

    }

}
