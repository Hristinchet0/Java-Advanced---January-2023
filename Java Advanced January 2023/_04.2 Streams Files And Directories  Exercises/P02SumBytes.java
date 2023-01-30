import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {

        String pathTFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        /*List<String> allLines = Files.readAllLines(Path.of(pathTFile));

        long sum = 0;

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }

        System.out.println(sum); */



       /* long sum = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathTFile))) {
            String line = reader.readLine();

            while (line != null) {
                for (char symbol : line.toCharArray()) {
                    sum += symbol;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum); */

        long sum = 0;

        byte[] allBytes = Files.readAllBytes(Path.of(pathTFile)); //array with ascii codes to all symbols + /n and /r

        for (byte ascii : allBytes) {
            // 10 is /n , 13 is /r (new row and carraiage return)
            if(ascii != 10 && ascii != 13) {
                sum += ascii;
            }
        }

        System.out.println(sum);



    }
}
