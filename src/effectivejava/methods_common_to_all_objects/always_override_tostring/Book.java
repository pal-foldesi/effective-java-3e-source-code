package effectivejava.methods_common_to_all_objects.always_override_tostring;

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

    public static void main(String[] args) {
        Book book = new Book("Dr. Jekyll and Mr. Hyde", "Robert Louis Stevenson", "978-0-553-21277-8", 231);
        System.out.println(book);
    }
}
