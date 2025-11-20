import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Тесты для объектной модели резюме.
 * TDD: Test-driven development, TDD, Разработка через тестирование
 */
public class ResumeTest {
    /**
     * Пример резюме
     */
    @Test
    public void testResume1() {
        Resume resume = new Resume();
        assertNotNull(resume);
    }

    @Test
    public void testResumeConstruction() {
        Resume resume = new Resume();
        assertNotNull(resume);
        assertNull(resume.fio);
        assertNull(resume.date);
    }

    @Test
    public void testResumeSetFio() {
        Resume resume = new Resume();
        resume.fio = "Иванов Иван Иванович";
        assertEquals("Иванов Иван Иванович", resume.fio);
    }

    @Test
    public void testResumeSetDate() {
        Resume resume = new Resume();
        Date date = new Date();
        resume.date = date;
        assertEquals(date, resume.date);
    }

    @Test
    public void testResumeWithAllFields() {
        Resume resume = new Resume();
        resume.fio = "Петров Петр Петрович";
        Date birthDate = new Date(90, 0, 1); // Jan 1, 1990
        resume.date = birthDate;

        assertEquals("Петров Петр Петрович", resume.fio);
        assertEquals(birthDate, resume.date);
    }

    @Test
    public void testResumeEmptyFio() {
        Resume resume = new Resume();
        resume.fio = "";
        assertEquals("", resume.fio);
    }

    @Test
    public void testMultipleResumes() {
        Resume resume1 = new Resume();
        resume1.fio = "Сидоров Сидор Сидорович";

        Resume resume2 = new Resume();
        resume2.fio = "Федоров Федор Федорович";

        assertNotEquals(resume1.fio, resume2.fio);
    }
}
