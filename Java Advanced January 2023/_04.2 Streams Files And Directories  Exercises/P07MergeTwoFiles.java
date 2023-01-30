import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String pathOneFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathTwoFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String pathToSave = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputMerge.txt";

        PrintWriter printWriter = new PrintWriter(pathToSave);

        List<String> allLinesFileOne = Files.readAllLines(Path.of(pathOneFile));
        List<String> allLinesFileTwo = Files.readAllLines(Path.of(pathTwoFile));

        allLinesFileOne.forEach(line -> printWriter.println(line));
        allLinesFileTwo.forEach(line -> printWriter.println(line));

        printWriter.close();

    }
}
