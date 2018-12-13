package effectivejava.methods_common_to_all_objects.consider_implementing_comparable;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public final class Book implements Comparable<Book> {
    private final String title;
    private final String author;
    private final String isbn;
    private final int pageCount;

    public Book(String title, String author, String isbn, int pageCount) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);
        Objects.requireNonNull(isbn);

        if (pageCount < 1) {
            throw new IllegalArgumentException("The book would be too short!");
        }

        validate(isbn);

        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pageCount = pageCount;
    }

    private static void validate(String isbn) {
        //lazy validation... we would normally verify length etc. here
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book))
            return false;
        Book that = (Book)o;
        return this.title.equals(that.title) && this.author.equals(that.author) &&
                this.isbn.equals(that.isbn) && this.pageCount == that.pageCount;
    }

    @Override public int hashCode() {
        int result = this.title.hashCode();
        result = 31 * result + this.author.hashCode();
        result = 31 * result + this.isbn.hashCode();
        result = 31 * result + Integer.hashCode(pageCount);
        return result;
    }

    /* Returns the string representation of this book.
    The string contains the title, author, ISBN and page count.*/
    @Override public String toString() {
        return String.format("%24s by %24s, ISBN %16s, %6d pages",
                title, author, isbn, pageCount);
    }

    private static final Comparator<Book> COMPARATOR = Comparator.comparing((Book book) -> book.title)
            .thenComparing(book -> book.author)
            .thenComparing(book -> book.isbn)
            .thenComparingInt(book -> book.pageCount);

    @Override
    public int compareTo(Book book) {
        return COMPARATOR.compare(this, book);
    }

    public static void main(String[] args) {
        Book book = new Book("Dr. Jekyll and Mr. Hyde", "Y", "0", 1);
        Book book2 = new Book("War As I Knew It", "Y", "0", 1);
        Book book3 = new Book("The Colour Of Magic", "Y", "0", 1);
        Book book4 = new Book("A Crown of Swords", "Y", "0", 1);
        Set<Book> books = new TreeSet<>();
        books.add(book);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.forEach(oneBook -> System.out.println(oneBook));
        book = new Book("X", "Robert Louis Stevenson", "0", 1);
        book2 = new Book("X", "George S. Patton", "0", 1);
        book3 = new Book("X", "Terry Pratchett", "0", 1);
        book4 = new Book("X", "Robert Jordan", "0", 1);
        books = new TreeSet<>();
        books.add(book);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.forEach(oneBook -> System.out.println(oneBook));
        book = new Book("X", "Y", "9780553212778", 1);
        book2 = new Book("X", "Y", "9780553259919", 1);
        book3 = new Book("X", "Y", "9780861403240", 1);
        book4 = new Book("X", "Y", "9780312857675", 1);
        books = new TreeSet<>();
        books.add(book);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.forEach(oneBook -> System.out.println(oneBook));
        book = new Book("X", "Y", "0", 231);
        book2 = new Book("X", "Y", "0", 416);
        book3 = new Book("X", "Y", "0", 205);
        book4 = new Book("X", "Y", "0", 881);
        books = new TreeSet<>();
        books.add(book);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.forEach(oneBook -> System.out.println(oneBook));
    }
}
