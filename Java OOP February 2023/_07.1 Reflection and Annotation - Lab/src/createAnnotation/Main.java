package createAnnotation;

import reflection_01.Reflection;

import java.lang.annotation.Annotation;

@Subject(categories = {"Reflection", "Annotation"})
public class Main {
    public static void main(String[] args) {

        Class a = Reflection.class;
        Annotation[] annotations = a.getAnnotations();

        Annotation annotation = a.getAnnotation(Subject.class);




    }
}
