import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class P01ReadFile {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (InputStream inputStream = new FileInputStream(filePath)) {
            int readByte = inputStream.read();
            while (readByte >=0) {
                System.out.print(Integer.toBinaryString(readByte) + " ");

                readByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        InputStream inputStream = new FileInputStream(filePath);
//
//        int firstByte = inputStream.read();
//
//        System.out.println(firstByte);
//        System.out.println((char) firstByte);
//
//
//        inputStream.close();
    }
}
