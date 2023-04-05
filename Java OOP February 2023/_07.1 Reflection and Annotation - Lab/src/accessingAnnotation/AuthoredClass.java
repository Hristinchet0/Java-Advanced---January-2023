package accessingAnnotation;

import java.lang.annotation.Annotation;

@Author(name = "Gosho")
public class AuthoredClass {
    public static void main(String[] args) {
        Class cl = AuthoredClass.class;
        Author author = (Author) cl.getAnnotation(Author.class);
        System.out.println(author.name());


        Class clazz = AuthoredClass.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(Author.class)) {
                Author author1 = (Author) annotation;
                System.out.println(author1.name());
            }
        }

    }
}

