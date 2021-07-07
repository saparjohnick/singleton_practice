import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Catalog {
    private List<Book> books = new LinkedList<Book>();

    private static Catalog catalog;
    public static Catalog instance() {
        if (catalog == null) {
            return catalog = new Catalog();
        } else {
            return catalog;
        }
    }

    public Book search(String bookId) {
        // code
        return null;
    }

    public boolean removeBook(String bookId) {

        return false;
    }

    public boolean insertBook(Book book) {
        return this.books.add(book);
    }

    public Iterator<Book> getBooks() {
        return this.books.iterator();
    }
}
