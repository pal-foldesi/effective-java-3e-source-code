package effectivejava.methods_common_to_all_objects.override_clone_judiciously;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Adding a clone method to Book
public final class Book implements Cloneable {
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

    // Clone method for class with no references to mutable state
    @Override public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // Can't happen
        }
    }

    public static void main(String[] args) {
        Book book = new Book("Dr. Jekyll and Mr. Hyde", "Robert Louis Stevenson", "978-0-553-21277-8", 231);
        Map<Book, String> m = new HashMap<>();
        m.put(book, "Jenny");
        Book b2 = book.clone();
        System.out.println(b2);
    }
}
