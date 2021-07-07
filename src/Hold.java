import java.util.Calendar;
import java.util.GregorianCalendar;

public class Hold {
    private Member member;
    private Book book;
    private Calendar date;

    public Hold(Member member, Book book, int duration) {
        this.member = member;
        this.book = book;
        this.date = new GregorianCalendar();
        this.date.setTimeInMillis(System.currentTimeMillis());
        this.date.add(Calendar.DATE, duration);
    }

    public Member getMember() {
        return this.member;
    }

    public Book getBook() {
        return this.book;
    }

    public Calendar getDate() {
        return this.date;
    }

    public boolean isValid() {
        return (System.currentTimeMillis() < date.getTimeInMillis());
    }
}
