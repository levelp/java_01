import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Animal
 */
public class AnimalTest {

    @Test
    public void testAnimalCreation() {
        Animal animal = new Animal();
        assertNotNull(animal);
    }

    @Test
    public void testAnimalNameField() {
        Animal animal = new Animal();
        animal.name = "Lion";
        assertEquals("Lion", animal.name);
    }

    @Test
    public void testAnimalDescriptionField() {
        Animal animal = new Animal();
        animal.description = "King of the jungle";
        assertEquals("King of the jungle", animal.description);
    }

    @Test
    public void testAnimalBothFields() {
        Animal animal = new Animal();
        animal.name = "Eagle";
        animal.description = "Flies high in the sky";

        assertEquals("Eagle", animal.name);
        assertEquals("Flies high in the sky", animal.description);
    }

    @Test
    public void testAnimalNullName() {
        Animal animal = new Animal();
        assertNull(animal.name);
    }

    @Test
    public void testAnimalNullDescription() {
        Animal animal = new Animal();
        assertNull(animal.description);
    }

    @Test
    public void testAnimalEmptyName() {
        Animal animal = new Animal();
        animal.name = "";
        assertEquals("", animal.name);
    }

    @Test
    public void testAnimalEmptyDescription() {
        Animal animal = new Animal();
        animal.description = "";
        assertEquals("", animal.description);
    }
}
