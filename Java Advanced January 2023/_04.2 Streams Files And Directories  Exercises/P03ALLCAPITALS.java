import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P03ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String pathTFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPathFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPathFile));

        //начин 1;
       /* List<String> allLines = Files.readAllLines(Path.of(pathTFile));
        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();*/

        //начин 2
        BufferedReader reader = new BufferedReader(new FileReader(pathTFile));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();
            line = reader.readLine();
        }
        writer.close();
    }
}
