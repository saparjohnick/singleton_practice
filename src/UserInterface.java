import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;


public class UserInterface {
    private static final int ADD_BOOKS = 1;
    private static final int ADD_MEMBER = 2;
    private static final int ISSUE_BOOKS = 3;
    private static final int EXIT = 0;
    private Library library;

    public static void main(String[] s) {
        UserInterface.instance().process();
    }

    private static UserInterface userInterface;
    public static UserInterface instance() {
        if (userInterface == null) {
            return userInterface = new UserInterface();
        } else {
            return userInterface;
        }
    }

    private UserInterface() {
        File file = new File("LibraryData");
        if (file.exists() && file.canRead()) {
            if (yesOrNo("Saved data exists. Use it?")) {
                library.retrieve();
            }
        }
        library = Library.instance();
    }

    private boolean yesOrNo(String s) {
        return false;
    }

    public void process() {
        int command;
//        help();
        while((command = getCommand()) != EXIT) {
            switch (command) {
                case ADD_MEMBER:    addMembers();
                                    break;
                case ADD_BOOKS:     addBooks();
                                    break;
                case ISSUE_BOOKS:   issueBooks();
                                    break;
                // several lines of code not shown
//                case HELP:          help();
//                                    break;

            }
        }
    }

    private int getCommand() {
        return 0;
    }

    private void addMembers() {
        Member result;
        do {
            String name = getToken("Enter name");
            String address = getToken("Enter address");
            String phone = getToken("Enter phone");
            result = library.addMember(name, address, phone);
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("Member could not be added");
            }
            if (!yesOrNo("Add more members?")) {
                break;
            }
        } while (true);
    }

    public void addBooks() {
        Book result;
        do {
            String title = getToken("Enter book title");
            String author = getToken("Enter author");
            String bookId = getToken("Enter id");
            result = library.addBook(title, author, bookId);
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("Book could not be added");
            }
            if (!yesOrNo("Add more books?")) {
                break;
            }
        } while(true);
    }

    public void issueBooks() {
        Book result;
        String memberID = getToken("Enter book id");
        if (library.searchMembership(memberID) == null) {
            System.out.println("No such member");
            return;
        }
        do {
            String bookID = getToken("Enter book id");
            result = library.issueBook(bookID, memberID);
            if (result != null) {
                System.out.println(result.getTitle() + "   " + result.getDueDate());
            } else {
                System.out.println("Book could not be issued");
            }
            if (!yesOrNo("Issue more books?")) {
                break;
            }
        } while(true);
    }

    public void getTransactions() {
        Iterator result;
        String memberID = getToken("Enter member id");
        Calendar date = getDate("Please enter the date for which you want " + "records as mm/dd/yy");
        result = library.getTransactions(memberID, date);
        if (result == null) {
            System.out.println("Invalid Member ID");
        } else {
            while(result.hasNext()) {
                Transaction transaction = (Transaction) result.next();
                System.out.println(transaction.getType() + "  " + transaction.getTitle() + "\n");
            }
        }
    }

    private Calendar getDate(String s) {
        return Calendar.getInstance();
    }

    private void save() throws IOException {
        if (library.save()) {
            System.out.println("The library has been successfully saved \n");
        } else {
            System.out.println("There has an error in saving \n");
        }
    }


    private String getToken(String question) {
        System.out.println(question);
        return question;
    }


}
