import java.io.*;

public class P09SerializeCustomObject {

    static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double depth;
    }
    public static void main(String[] args) {

        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;

        String path = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\save.txt";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
