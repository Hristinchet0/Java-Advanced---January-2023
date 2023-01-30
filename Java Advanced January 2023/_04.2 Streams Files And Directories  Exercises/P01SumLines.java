import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P01SumLines {
    public static void main(String[] args) throws IOException {

        //1.Всички редове от файла
        //2.за всеки ред -> намирам сумата на ascii -> принтиране

        String pathTFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathTFile));

        //начин 1:
       /* for (String line : allLines) {
            //line = "Michael Angelo, "
            int sum = 0; //сумата от кодовете на символите на този ред
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        }*/

        //начин 2:
        allLines
                .forEach(line -> {
                    int sum = 0; //сумата от кодовете на символите на този ред
                    for (char symbol : line.toCharArray()) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });

    }
}