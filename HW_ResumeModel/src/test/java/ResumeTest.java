import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Date;

/**
 * Comprehensive test class for Resume
 * TDD: Test-driven development, TDD, Разработка через тестирование
 */
public class ResumeTest {

    private Resume resume;

    @Before
    public void setUp() {
        resume = new Resume();
    }

    /**
     * Test that Resume can be instantiated
     */
    @Test
    public void testInstantiation() {
        Resume r = new Resume();
        assertNotNull("Resume instance should not be null", r);
    }

    /**
     * Test default fio value is null
     */
    @Test
    public void testDefaultFioIsNull() {
        assertNull("Default fio should be null", resume.fio);
    }

    /**
     * Test default date value is null
     */
    @Test
    public void testDefaultDateIsNull() {
        assertNull("Default date should be null", resume.date);
    }

    /**
     * Test setting fio field
     */
    @Test
    public void testSetFio() {
        resume.fio = "Иванов Иван Иванович";
        assertEquals("fio should be set correctly", "Иванов Иван Иванович", resume.fio);
    }

    /**
     * Test setting fio to empty string
     */
    @Test
    public void testSetFioEmptyString() {
        resume.fio = "";
        assertEquals("fio should accept empty string", "", resume.fio);
    }

    /**
     * Test setting date field
     */
    @Test
    public void testSetDate() {
        Date birthDate = new Date();
        resume.date = birthDate;
        assertEquals("date should be set correctly", birthDate, resume.date);
    }

    /**
     * Test setting date to specific value
     */
    @Test
    public void testSetDateSpecificValue() {
        Date birthDate = new Date(0); // January 1, 1970
        resume.date = birthDate;
        assertNotNull("date should not be null after setting", resume.date);
        assertEquals("date should match set value", birthDate, resume.date);
    }

    /**
     * Test multiple Resume instances are independent
     */
    @Test
    public void testMultipleInstances() {
        Resume resume1 = new Resume();
        Resume resume2 = new Resume();

        resume1.fio = "Петров";
        resume2.fio = "Сидоров";

        assertNotSame("Different instances should not be the same object", resume1, resume2);
        assertEquals("resume1.fio should be Петров", "Петров", resume1.fio);
        assertEquals("resume2.fio should be Сидоров", "Сидоров", resume2.fio);
    }

    /**
     * Test setting all fields
     */
    @Test
    public void testSetAllFields() {
        resume.fio = "Козлов Козьма Козьмич";
        resume.date = new Date();

        assertNotNull("fio should not be null after setting", resume.fio);
        assertNotNull("date should not be null after setting", resume.date);
    }

    /**
     * Test updating fio value
     */
    @Test
    public void testUpdateFio() {
        resume.fio = "Первое Имя";
        assertEquals("fio should be first name", "Первое Имя", resume.fio);

        resume.fio = "Второе Имя";
        assertEquals("fio should be updated to second name", "Второе Имя", resume.fio);
    }

    /**
     * Test updating date value
     */
    @Test
    public void testUpdateDate() {
        Date firstDate = new Date(1000000);
        Date secondDate = new Date(2000000);

        resume.date = firstDate;
        assertEquals("date should be first date", firstDate, resume.date);

        resume.date = secondDate;
        assertEquals("date should be updated to second date", secondDate, resume.date);
    }

    /**
     * Test fio with special characters
     */
    @Test
    public void testFioWithSpecialCharacters() {
        resume.fio = "Иванов-Петров Иван О'Коннор";
        assertEquals("fio should handle special characters",
                     "Иванов-Петров Иван О'Коннор", resume.fio);
    }

    /**
     * Test fio with numbers
     */
    @Test
    public void testFioWithNumbers() {
        resume.fio = "Иванов Иван 2-й";
        assertEquals("fio should handle numbers", "Иванов Иван 2-й", resume.fio);
    }

    /**
     * Test setting fio to null after setting a value
     */
    @Test
    public void testSetFioToNull() {
        resume.fio = "Some Name";
        resume.fio = null;
        assertNull("fio should be null after setting to null", resume.fio);
    }

    /**
     * Test setting date to null after setting a value
     */
    @Test
    public void testSetDateToNull() {
        resume.date = new Date();
        resume.date = null;
        assertNull("date should be null after setting to null", resume.date);
    }

    /**
     * Test long fio value
     */
    @Test
    public void testLongFioValue() {
        String longName = "Очень Длинное Имя Отчество Фамилия Которое Может Быть Слишком Длинным";
        resume.fio = longName;
        assertEquals("fio should accept long values", longName, resume.fio);
    }
}
