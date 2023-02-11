package P01JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<String> jarString = new Jar<>();

        jarString.add("Pesho");
        jarString.add("Ivan");

        Jar<Integer> jarInteger =new Jar<>();

        jarInteger.add(150);

    }
}
