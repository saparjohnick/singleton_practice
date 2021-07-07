import java.util.*;

public class Book {
    private String title;
    private String author;
    private String id;
    private Member borrowedBy;
    private List<Hold> holds;
    private Calendar dueDate;

    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public boolean issue(Member member) {
        this.borrowedBy = member;
        this.dueDate = new GregorianCalendar();
        this.dueDate.setTimeInMillis(System.currentTimeMillis());
        this.dueDate.add(Calendar.MONTH, 1);
        return true;
    }

    public Member returnBook() {
        // code
        return null;
    }

    public boolean renew(Member member) {
        return false;
    }

    public void placeHold(Hold hold) {
        this.holds.add(hold);
    }

    public boolean removeHold(String memberId) {
        // code
        return false;
    }

    public Hold getNextHold() {
        for (ListIterator iterator = this.holds.listIterator(); iterator.hasNext(); ) {
            Hold hold = (Hold) iterator.next();
            iterator.remove();
            if (hold.isValid()) {
                return hold;
            }
        }
        return null;
    }

    public Iterator getHolds() {
        return this.holds.iterator();
    }

    public boolean hasHold() {
        return this.holds.iterator().hasNext();
    }

    public Calendar getDueDate() {
        return this.dueDate;
    }

    public Member getBorrower() {
        return this.borrowedBy;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getId() {
        return this.id;
    }
}
