import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) throws IOException {
        //1.стъпка -> да намерим думите които ще броим
        //words.txt -> думи които трябва да търсим
        String pathToFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        //дума, бр. срещания
        Map<String, Integer> countWords = new HashMap<>();

        for (String line : allLines) {
            String[] currentRow = line.split("\\s+");
            Arrays.stream(currentRow).forEach(word -> {
                countWords.put(word, 0);
            });
        }

        //2. стъпка - > да си преброим колко пъти думите се срещат във файла text.txt
        //countWord -> държим думите които търсим
        String pathToFileText = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLineSWithText = Files.readAllLines(Path.of(pathToFileText));

        for (String line : allLineSWithText) {
            String[] wordsRow = line.split("\\s+");
            for (String word: wordsRow) {
                if(countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word) + 1);
                }
            }
        }
        //3.стъпка -> знаем коя дума колко пъти се среща
        //сортираме записите по броя на срещанията -> sort by Value in descending order
        String pathToSave = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";
        PrintWriter printWriter = new PrintWriter(pathToSave);
        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> printWriter.println(entry.getKey() + " - " + entry.getValue()));


        printWriter.close();
    }
}