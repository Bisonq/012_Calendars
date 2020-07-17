package Calendar;
import java.text.DateFormatSymbols;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class EnumeratingCalendar {

    private GregorianCalendar calendar;

    public EnumeratingCalendar(int year, int month, int day) {
        this.calendar = new GregorianCalendar(year, month - 1, day);
    }

    public EnumeratingCalendar(GregorianCalendar calendar) {
        this.calendar = calendar;
    }

    public int getDayOfMonth(GregorianCalendar calendar){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth(GregorianCalendar calendar){
        return calendar.get(Calendar.MONTH);
    }

    public int getDayOfWeek(GregorianCalendar calendar){
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public int getFirstDayOfWeek(GregorianCalendar calendar){
        return calendar.getFirstDayOfWeek();
    }

    public String[] getWeekdayNames(){
        Locale.setDefault(new Locale("en", "GB"));
        String[] tab = new DateFormatSymbols().getShortWeekdays();
        return tab;
    }

    public void setDate(int year, int month, int day){
        this.calendar.set(year, month - 1, day);
    }

    public void setMonth(int month){
        this.calendar.set(Calendar.MONTH, month-1);
    }

    public void printAnnualCalendar(){
        for(int i = 1 ; i <= 12 ; i ++){
            setMonth(i);
            printMonthlyCalendar();
        }
    }

    public void printMonthlyCalendar(){
        int today = getDayOfMonth(calendar);
        int month = getMonth(calendar);

        System.out.print(Month.of(calendar.get(Calendar.MONTH) + 1));
        System.out.println(" " + Year.of(calendar.getWeekYear()));

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int weekday = getDayOfWeek(calendar);

        int firstDayOfWeek = getFirstDayOfWeek(calendar);

        int indent = 0;
        while(weekday != firstDayOfWeek){
            indent++;
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            weekday = getDayOfWeek(calendar);
        }

        printWeekdayNames(weekday, firstDayOfWeek, indent);

        weekday = printDaysOfWeek(today, month, firstDayOfWeek);

        if(weekday != firstDayOfWeek) System.out.println();
        System.out.println();
    }

    private void printWeekdayNames(int weekday, int firstDayOfWeek, int indent) {
        String[] weekdayNames = getWeekdayNames();
        do{
            System.out.printf("%5s", weekdayNames[weekday]);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            weekday = getDayOfWeek(calendar);
        }while (weekday != firstDayOfWeek);
        System.out.println();

        for(int i = 1 ; i <= indent; i++)
            System.out.print("     ");

        calendar.set(Calendar.DAY_OF_MONTH, 1);
    }

    private int printDaysOfWeek(int today, int month, int firstDayOfWeek) {
        int weekday;
        do{
            int day = getDayOfMonth(calendar);
            System.out.printf("%4d", day);

            if(day == today) System.out.print("*");
            else System.out.print(" ");

            calendar.add(Calendar.DAY_OF_MONTH, 1);
            weekday = getDayOfWeek(calendar);

            if(weekday == firstDayOfWeek) System.out.println();
        }while(getMonth(calendar) == month);
        return weekday;
    }
}
