package P4BookComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        BookComparator comparator = new BookComparator();

        books.stream()
                .sorted(comparator)
                .forEach(b -> System.out.println(b));
    }
}
