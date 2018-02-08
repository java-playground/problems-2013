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

public class Base {

    static void doTask(String input) {

        // do something with file

    }

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/exampleIO/Prob01.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while((line = reader.readLine()) != null) {
                doTask(line);
            }

        } catch(IOException e) { System.err.println(e); }

    }

}
