import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        String pathToFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String pathToSaveFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_Line_numbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        PrintWriter printWriter = new PrintWriter(pathToSaveFile);
        int lineNumber = 1;

        for (String line : allLines) {
            printWriter.printf("%d. %s%n", lineNumber, line);
            lineNumber++;
        }

        printWriter.close();
    }
}
