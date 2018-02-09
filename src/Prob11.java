import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Prob11 {

    static void doTask(String input) {

        String[] parts = input.split(";");
        String op = parts[0];
        String type = parts[1];
        String in = parts[2];
        switch(op) {
            case "S":
                List<String> words = new ArrayList<>();
                Pattern word = Pattern.compile("^[a-z]+|[A-Z][a-z]+");
                Matcher wordMatcher = word.matcher(in);
                while(wordMatcher.find()) {
                    words.add(wordMatcher.group().toLowerCase());
                }
                System.out.println(String.join(" ", words));
                break;
            default:
            case "C":
                String post = "";
                boolean isClass = false;
                AtomicBoolean first = new AtomicBoolean(true);
                switch(type) {
                    case "C":
                        first.set(false);
                        isClass = true;
                    case "M":
                        if(!isClass)
                            post = "()";
                    case "V":
                        System.out.println(String.join("", Arrays.stream(in.split(" "))
                                .map(str -> {
                                    if(first.get()) {
                                        first.set(false);
                                        return str.toLowerCase();
                                    }
                                    return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
                                })
                                .collect(Collectors.toList())));

                }
        }

    }

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob11.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            while((line = reader.readLine()) != null) {
                doTask(line);
            }

        } catch(IOException e) { System.err.println(e); }

    }

}
