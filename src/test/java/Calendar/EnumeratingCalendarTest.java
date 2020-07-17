package Calendar;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumeratingCalendarTest {

    @Test
    public void shouldReturnCorrectDayOfTheMonth(){
        //given
        GregorianCalendar calendar = new GregorianCalendar(2020, Calendar.JULY, 17);
        EnumeratingCalendar enumeratingCalendar = new EnumeratingCalendar(calendar);

        //when
        int day = enumeratingCalendar.getDayOfMonth(calendar);

        //then
        assertThat(day).isEqualTo(17);
    }

    @Test
    public void shouldReturnCorrectMonth(){
        //given
        GregorianCalendar calendar = new GregorianCalendar(2020, Calendar.JULY, 17);
        EnumeratingCalendar enumeratingCalendar = new EnumeratingCalendar(calendar);

        //when
        int month = enumeratingCalendar.getMonth(calendar);

        //then
        assertThat(month).isEqualTo(6);
    }

    @Test
    public void shouldReturnCorrectDayOfWeek(){
        //given
        GregorianCalendar calendar = new GregorianCalendar(2020, Calendar.JULY, 17);
        EnumeratingCalendar enumeratingCalendar = new EnumeratingCalendar(calendar);

        //when
        int dayOfWeek = enumeratingCalendar.getDayOfWeek(calendar);

        //then
        assertThat(dayOfWeek).isEqualTo(6);
    }


    @Test
    public void shouldReturnCorrectFirstDayOfWeek(){
        //given
        GregorianCalendar calendar = new GregorianCalendar(2020, Calendar.JULY, 17);
        EnumeratingCalendar enumeratingCalendar = new EnumeratingCalendar(calendar);

        //when
        int firstDayOfWeek = enumeratingCalendar.getFirstDayOfWeek(calendar);

        //then
        assertThat(firstDayOfWeek).isEqualTo(2);
    }

    @Test
    public void shouldReturnCorrectsWeekdayNames(){
        //given
        GregorianCalendar calendar = new GregorianCalendar(2020, Calendar.JULY, 17);
        EnumeratingCalendar enumeratingCalendar = new EnumeratingCalendar(calendar);

        //when
        String[] weekdayName = enumeratingCalendar.getWeekdayNames();

        //then
        assertThat(weekdayName[1]).isEqualTo("Sun");
        assertThat(weekdayName[3]).isEqualTo("Tue");
        assertThat(weekdayName[5]).isEqualTo("Thu");
        assertThat(weekdayName[7]).isEqualTo("Sat");
    }
}
