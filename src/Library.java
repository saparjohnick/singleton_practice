import java.io.*;
import java.util.Calendar;
import java.util.Iterator;

public class Library {
    private MemberList members;
    private Catalog books;

    public static final int BOOK_NOT_FOUND = 1;
    public static final int BOOK_NOT_ISSUED = 2;

    private static Library library;
    public static Library instance() {
        if (library == null) {
            return library = new Library();
        } else {
            return library;
        }

    }

    public boolean save() throws IOException {
        try{
            FileOutputStream file = new FileOutputStream("LibraryData");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(library);
            output.writeObject(MemberIdServer.instance());
            return true;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return false;
        }

    }
// the default readObject overriden to ignore retrival of copy already exists in memory
    private void readObject(ObjectInputStream input) {
        try {
            input.defaultReadObject();
            if (library == null) {                      // checking to avoid second instance via deserialization of file
                library = (Library) input.readObject();
            } else {
                input.readObject();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Library retrieve() {
        try {
            FileInputStream file = new FileInputStream("LibraryData");
            ObjectInputStream input = new ObjectInputStream(file);
            input.readObject();
            MemberIdServer.retrieve(input);
            return library;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return null;
        }
    }

    public Book addBook(String title, String author, String id) {
        Book book = new Book(title, author, id);
        if (books.insertBook(book)) {
            return book;
        }
        return null;
    }

    public Member addMember(String name, String address, String phone) {
        Member member = new Member(name, address, phone);
        if (members.insertMember(member)) {
            return member;
        }
        return null;
    }

    public Book issueBook(String bookId, String memberId) {
        Book book = books.search(bookId);
        if (book == null) {
            return (null);
        }
        if (book.getBorrower() != null) {
            return (null);
        }
        Member member = members.search(memberId);
        if (member == null) {
            return (null);
        }
        if (book.issue(member) && member.issue(book)) {
            return (null);
        }
        return (book);
    }

    public int returnBook(String bookId) {
        // code
        return 0;
    }

    public int removeBook(String bookId) {
        // code
        return 0;
    }

    public int placeHold(String memberId, String bookId) {
        // code
        return 0;
    }

    public Member processHold(String bookId) {
        // code
        return null;
    }

    public int removeHold(String memberId, String bookId) {
        // code
        return 0;
    }

    public Member searchMembership(String memberId) {
        // code
        return null;
    }

    public Book renewBook(String memberId, String bookId) {
        // code
        return null;
    }

    public Iterator getTransactions(String memberId, Calendar date) {
        // code
        return null;
    }

    public Iterator getBooks(String memberId) {
        // code
        return null;
    }

}
