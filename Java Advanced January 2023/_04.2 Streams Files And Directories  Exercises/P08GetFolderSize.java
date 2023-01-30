import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {

        String pathToFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(pathToFile);

        File[] allFilesInFolder = folder.listFiles(); //масив с всички файлове в папката

        int folderSize = 0;
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {

                folderSize += file.length();
            }
        }
        System.out.printf("Folder size: %d", folderSize);


    }
}
