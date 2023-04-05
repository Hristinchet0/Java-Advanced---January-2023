package highQualityMistakes_03;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;

        Field[] fields = reflection.getDeclaredFields();

        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(field -> System.out.printf("%s%n", field.getName()));

        Method[] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(System.out::println);


    }
}
