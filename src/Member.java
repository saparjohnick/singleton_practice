import java.util.*;

public class Member {
    private String name;
    private String address;
    private String phone;

    private List<Book> booksBorrowed = new LinkedList();
    private List<Hold> booksOnHold = new LinkedList();
    private List<Transaction> transactions = new LinkedList();

    public Member(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public boolean issue(Book book) {
        if (booksBorrowed.add(book)) {
            transactions.add(new Transaction("Book issued ", book.getTitle()));
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        // code
        return false;
    }

    public boolean renew(Book book) {
        // code
        return false;
    }

    public void placeHold(Hold hold) {
        transactions.add(new Transaction("Hold placed", hold.getBook().getTitle()));
        booksOnHold.add(hold);
    }

    public boolean removeHold(String bookId) {
        boolean removed = false;
        for (ListIterator iterator = booksOnHold.listIterator(); iterator.hasNext(); ) {
            Hold hold = (Hold) iterator.next();
            String id = hold.getBook().getId();
            if(id.equals(bookId)) {
                transactions.add(new Transaction("Hold removed", hold.getBook().getTitle()));
                removed = true;
                iterator.remove();
            }
        }
        return removed;
    }

    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public String getPhone() {
        return this.phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Iterator getTransactions(Calendar date) {
        List result = new LinkedList();
        for (Iterator iterator = this.transactions.iterator(); iterator.hasNext(); ) {
            Transaction transaction = (Transaction) iterator.next();
            if (transaction.onDate(date)) {
                result.add(transaction);
            }
        }
        return result.iterator();
    }

    public Iterator getBooksIssued() {
        // code
        return null;
    }
}
