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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Prob05 {

    static Date end;
    static SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    static void doTask(String input) throws ParseException {

        String[] parts = input.split(":");
        Date start = df.parse(parts[1]);

        TimeUnit timeUnit = TimeUnit.DAYS;
        long days = timeUnit.convert(end.getTime() - start.getTime(), TimeUnit.MILLISECONDS);
        if(days > 30) {
            System.out.printf("%s, %d%n", parts[0], days);
        }

    }

    public static void main(String[] args) {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob05.in.txt"), Charset.forName("US-ASCII"))) {

            end = df.parse(reader.readLine());

            String line;
            while ((line = reader.readLine()) != null) {
                doTask(line);
            }

        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException e) {
            System.err.println(e);
        }

    }

}
