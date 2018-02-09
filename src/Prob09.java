import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Prob09 {

    static String printSpecial(double input) {
        if(input % 1 == 0) {
            return String.format("%d", (int) input);
        } else {
            return String.format("%.1f", input);
        }
    }

    static void doTask(String input, int lineNumber) {

        // print line number
        System.out.printf("Set %d: ", lineNumber);

        List<Integer> numbers = Arrays.stream(input.split(","))
                .mapToInt(str -> Integer.parseInt(str))
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        int numNumbers = numbers.size();

        // calculating mean
        double mean = numbers.stream().mapToInt(i -> (int) i).sum() / (double) numNumbers;

        System.out.printf("Mean=%s ", printSpecial(mean));

        // calculating median
        double median;
        if(numNumbers % 2 == 0) {
            median = (numbers.get(numNumbers / 2 - 1) + numbers.get(numNumbers / 2))/2.0;
        } else {
            median = numbers.get((numNumbers - 1) / 2);
        }

        System.out.printf("Median=%s ", printSpecial(median));

        // calculating mode
        Set<Integer> numbersWithoutRepeats = new HashSet<>(numbers);
        int highestFrequency = 0;
        ArrayList<String> modes = new ArrayList<>();
        for(Integer num : numbersWithoutRepeats) {
            int frequency = (int) numbers.stream().filter(n -> n == num).count();
            if(frequency > highestFrequency) {
                modes = new ArrayList<>();
                modes.add("" + num);
                highestFrequency = frequency;
            } else if(frequency == highestFrequency) {
                modes.add("" + num);
            }
        }

        String modesString = String.join(",", modes);

        System.out.printf("Mode=%s%n", modesString);

    }

    public static void main(String[] args) {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("downloads/judgingIO/Prob09.in.txt"), Charset.forName("US-ASCII"))) {

            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                doTask(line, ++i);
            }

        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
