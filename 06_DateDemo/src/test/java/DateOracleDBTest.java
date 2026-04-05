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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        assertEquals("09.05.2014 01:02:03", dateFormat.format(d));
    }

    // Additional edge case tests for 100% coverage

    /**
     * Test toStr with January date
     */
    @Test
    public void testToStrJanuary() {
        Calendar c = Calendar.getInstance();
        c.set(2020, Calendar.JANUARY, 1, 0, 0, 0);
        Date date = c.getTime();
        String result = OracleDateHelper.toStr(date);
        assertTrue(result.startsWith("2020-01-01"));
    }

    /**
     * Test toStr with December date
     */
    @Test
    public void testToStrDecember() {
        Calendar c = Calendar.getInstance();
        c.set(2020, Calendar.DECEMBER, 31, 23, 59, 59);
        Date date = c.getTime();
        assertEquals("2020-12-31 23:59:59", OracleDateHelper.toStr(date));
    }

    /**
     * Test parse with midnight time
     */
    @Test
    public void testParseMidnight() throws ParseException {
        Date d = OracleDateHelper.parse("2020-06-15 00:00:00");
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        assertEquals(0, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, cal.get(Calendar.MINUTE));
        assertEquals(0, cal.get(Calendar.SECOND));
    }

    /**
     * Test parse with noon time
     */
    @Test
    public void testParseNoon() throws ParseException {
        Date d = OracleDateHelper.parse("2020-06-15 12:00:00");
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        assertEquals(12, cal.get(Calendar.HOUR_OF_DAY));
    }

    /**
     * Test parse and toStr are inverse operations
     */
    @Test
    public void testRoundTrip() throws ParseException {
        String original = "2021-07-20 14:30:45";
        Date d = OracleDateHelper.parse(original);
        String result = OracleDateHelper.toStr(d);
        assertEquals(original, result);
    }

    /**
     * Test toStr with different year
     */
    @Test
    public void testToStrDifferentYear() {
        Calendar c = Calendar.getInstance();
        c.set(1999, Calendar.MARCH, 15, 10, 20, 30);
        Date date = c.getTime();
        assertEquals("1999-03-15 10:20:30", OracleDateHelper.toStr(date));
    }

    /**
     * Test toStr with future date
     */
    @Test
    public void testToStrFutureDate() {
        Calendar c = Calendar.getInstance();
        c.set(2050, Calendar.JUNE, 30, 12, 0, 0);
        Date date = c.getTime();
        String result = OracleDateHelper.toStr(date);
        assertTrue(result.startsWith("2050-06-30"));
    }

    /**
     * Test parse with invalid format throws ParseException
     */
    @Test(expected = ParseException.class)
    public void testParseInvalidFormat() throws ParseException {
        OracleDateHelper.parse("invalid-date-string");
    }

    /**
     * Test parse with wrong date format throws ParseException
     */
    @Test(expected = ParseException.class)
    public void testParseWrongFormat() throws ParseException {
        OracleDateHelper.parse("15.06.2020 12:00:00"); // Wrong format (DD.MM.YYYY)
    }

    /**
     * Test parse with empty string throws ParseException
     */
    @Test(expected = ParseException.class)
    public void testParseEmptyString() throws ParseException {
        OracleDateHelper.parse("");
    }

    /**
     * Test toStr with epoch date
     */
    @Test
    public void testToStrEpoch() {
        Date epoch = new Date(0);
        String result = OracleDateHelper.toStr(epoch);
        assertNotNull(result);
        // The exact result depends on timezone
    }

    /**
     * Test parse with leap year date
     */
    @Test
    public void testParseLeapYear() throws ParseException {
        Date d = OracleDateHelper.parse("2020-02-29 12:00:00");
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        assertEquals(29, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.FEBRUARY, cal.get(Calendar.MONTH));
    }

    /**
     * Test multiple conversions
     */
    @Test
    public void testMultipleConversions() throws ParseException {
        String[] dates = {
            "2020-01-01 00:00:00",
            "2020-06-15 12:30:45",
            "2020-12-31 23:59:59"
        };

        for (String dateStr : dates) {
            Date d = OracleDateHelper.parse(dateStr);
            String result = OracleDateHelper.toStr(d);
            assertEquals(dateStr, result);
        }
    }

    /**
     * Test toStr format consistency
     */
    @Test
    public void testToStrFormatConsistency() {
        Calendar c = Calendar.getInstance();
        c.set(2020, Calendar.AUGUST, 5, 8, 5, 5);
        Date date = c.getTime();
        String result = OracleDateHelper.toStr(date);

        // Verify format: yyyy-MM-dd HH:mm:ss
        assertTrue(result.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"));
    }
}
