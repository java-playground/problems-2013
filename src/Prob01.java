import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Prob01 {

    static void doTask(String input) {

        System.out.println(input);

    }

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob01.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while((line = reader.readLine()) != null) {
                doTask(line);
            }

        } catch(IOException e) { System.err.println(e); }

    }

}
