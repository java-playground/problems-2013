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

public class Prob10 {

    static void doTask(String input) {

        // convert binary to decimal
        String[] parts = new String[4];
        for(int i = 0; i < input.length(); i+= 8)
            parts[i/8] = "" + Integer.parseInt(input.substring(i, i+8), 2);

        // class
        String type;
        int part1 = Integer.parseInt(parts[0]);
        if(part1 < 128) type = "A";
        else if(part1 < 192) type = "B";
        else if(part1 < 224) type = "C";
        else if(part1 < 240) type = "D";
        else type = "E";

        System.out.printf("%s [CLASS %s]%n", String.join(".", parts), type);

    }

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob10.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while((line = reader.readLine()) != null) {
                doTask(line);
            }

        } catch(IOException e) { System.err.println(e); }

    }

}
