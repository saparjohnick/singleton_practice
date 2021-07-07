import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Transaction implements Serializable {
    private Calendar date;
    private String bookTitle;
    private String type;

    public Transaction(String type, String title) {
        this.type = type;
        this.bookTitle = title;
        this.date = new GregorianCalendar();
        this.date.setTimeInMillis(System.currentTimeMillis());
    }

    public boolean onDate(Calendar date) {
        return ((date.get(Calendar.YEAR) == this.date.get(Calendar.YEAR)) &&
                (date.get(Calendar.MONTH) == this.date.get(Calendar.MONTH)) &&
                (date.get(Calendar.DATE) == this.date.get(Calendar.DATE)));
    }

    public String getType() {
        return this.type;
    }

    public String getTitle() {
        return this.bookTitle;
    }

    public String getDate() {
        return this.date.get(Calendar.DATE) + "/" + this.date.get(Calendar.MONTH) + "/" + this.date.get(Calendar.YEAR);
    }

    public String toString() {
        return (type + "   " + bookTitle);
    }
}
