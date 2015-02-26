import com.demo.OracleDateHelper;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование работы с датами
 */
public class DateOracleDBTest {
    @Test
    public void baseDate() throws ParseException {
        Calendar c = Calendar.getInstance();
        c.set(2014, Calendar.APRIL, 18);
        Date date = c.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        // Печать даты в строку
        assertEquals("18.04.2014", dateFormat.format(date));

        // Из строки в дату
        Date parsedDate = dateFormat.parse("19.05.2013");

        Calendar cal = Calendar.getInstance();
        cal.setTime(parsedDate);

        assertEquals(19, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.MAY, cal.get(Calendar.MONTH));
        assertEquals(2013, cal.get(Calendar.YEAR));
    }

    /**
     * Перевод даты в формат БД Oracle и обратно
     */
    @Test
    public void oracleDatabaseDateHelper() throws ParseException {
        // Из даты в Oracle
        Calendar c = Calendar.getInstance();
        c.set(2014, Calendar.MAY, 9, 1, 2, 3);
        Date date = c.getTime();
        Assert.assertEquals("2014-05-09 01:02:03", OracleDateHelper.toStr(date));

        // Из БД в дату
        Date d = OracleDateHelper.parse("2014-05-09 01:02:03");
        assertEquals("Fri May 09 01:02:03 MSK 2014", d.toString());
    }

}
