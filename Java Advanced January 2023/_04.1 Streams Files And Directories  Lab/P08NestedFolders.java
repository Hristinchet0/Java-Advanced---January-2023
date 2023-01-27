import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class P08NestedFolders {
    public static void main(String[] args) {

        String folderPath = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(folderPath);

        Queue<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if(nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
