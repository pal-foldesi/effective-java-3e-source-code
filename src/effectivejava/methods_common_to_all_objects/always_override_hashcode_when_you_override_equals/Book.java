package effectivejava.methods_common_to_all_objects.always_override_hashcode_when_you_override_equals;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Book {
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

    // Broken with no hashCode; works with any of the three below

    // Typical hashCode method
    /*@Override public int hashCode() {
        int result = this.title.hashCode();
        result = 31 * result + this.author.hashCode();
        result = 31 * result + this.isbn.hashCode();
        result = 31 * result + Integer.hashCode(pageCount);
        return result;
    }*/

    // One-line hashCode method - mediocre performance
    /*@Override public int hashCode() {
        return Objects.hash(this.title, this.author, this.isbn, this.pageCount);
    }*/

    // hashCode method with lazily initialized cached hash code
    /*private int hashCode; // Automatically initialized to 0

    @Override public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = this.title.hashCode();
            result = 31 * result + this.author.hashCode();
            result = 31 * result + this.isbn.hashCode();
            result = 31 * result + Integer.hashCode(pageCount);
            hashCode = result;
        }
        return result;
    }*/

    public static void main(String[] args) {
        Book book = new Book("The Realm Eternal", "Dr. Odson Forja", "0", 431);
        Map<Book, String> books = new HashMap<>();
        books.put(book, "Hiram");
        System.out.println(books.get(new Book("The Realm Eternal", "Dr. Odson Forja", "0", 431)));
    }
}
