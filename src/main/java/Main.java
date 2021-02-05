import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Taimoor Choudhary
 */
public class Main {

    static String pattern1 = "d/M/y";
    static String pattern2 = "dd/MM/yy";
    static String pattern3 = "dd/MMM/yyyy";
    static String pattern4 = "dd/MMMM/yyyy h:m:s.SSS a";
    static String pattern5 = "dd/MMMM/yyyy hh:mm:ss.SSS a";
    static String pattern6 = "E dd/MMMM/yyyy HH:mm:ss.SSS";
    static String pattern7 = "EEEE dd/MMMM/yyyy HH:mm:ss.SSS";

    static Date date = new Date();
    static LocalDateTime localDateTime = LocalDateTime.now();

    public static void main(String args[]){
        simpleDateFormat();
        dateTimeFormatter();
    }

    public static void simpleDateFormat(){
        try {

            displayDate(pattern1);
            displayDate(pattern2);
            displayDate(pattern3);
            displayDate(pattern4);
            displayDate(pattern5);
            displayDate(pattern6);
            displayDate(pattern7);

            parseDate(pattern7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayDate(String pattern) {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String dateString = format.format(date);
        System.out.println("Pattern: " + pattern + " | Date: " + dateString);
    }

    private static void parseDate(String pattern) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String dateString = format.format(date);
            Date date = format.parse (dateString);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void dateTimeFormatter(){
        displayLocalDate(pattern1);
        displayLocalDate(pattern2);
        displayLocalDate(pattern3);
        displayLocalDate(pattern4);
        displayLocalDate(pattern5);
        displayLocalDate(pattern6);
        displayLocalDate(pattern7);

        parseLocalDate(pattern7);
    }

    private static void parseLocalDate(String pattern) {

        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern(pattern);
        String dateString = dtformat.format(localDateTime);
        LocalDateTime date = LocalDateTime.from(dtformat.parse(dateString));
        System.out.println(date);
    }

    private static void displayLocalDate(String pattern) {

        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern(pattern);
        String dateString = dtformat.format(localDateTime);
        System.out.println("Pattern: " + pattern + " | Date: " + dateString);
    }
}
