package effectivejava.methods_common_to_all_objects.obey_the_general_contract_when_overriding_equals;

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

    // Remainder omitted - note that hashCode is REQUIRED
    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book))
            return false;
        Book that = (Book)o;
        return this.title.equals(that.title) && this.author.equals(that.author) &&
                this.isbn.equals(that.isbn) && this.pageCount == that.pageCount;
    }
}
