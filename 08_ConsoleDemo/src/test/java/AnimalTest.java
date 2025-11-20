import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testAnimalInstantiation() {
        Animal animal = new Animal();
        assertNotNull(animal);
    }

    @Test
    public void testAnimalName() {
        Animal animal = new Animal();
        animal.name = "Dog";
        assertEquals("Dog", animal.name);
    }

    @Test
    public void testAnimalDescription() {
        Animal animal = new Animal();
        animal.description = "A friendly pet";
        assertEquals("A friendly pet", animal.description);
    }

    @Test
    public void testAnimalNameAndDescription() {
        Animal animal = new Animal();
        animal.name = "Cat";
        animal.description = "A furry feline";

        assertEquals("Cat", animal.name);
        assertEquals("A furry feline", animal.description);
    }

    @Test
    public void testAnimalWithNullValues() {
        Animal animal = new Animal();
        assertNull(animal.name);
        assertNull(animal.description);
    }

    @Test
    public void testAnimalWithEmptyStrings() {
        Animal animal = new Animal();
        animal.name = "";
        animal.description = "";

        assertEquals("", animal.name);
        assertEquals("", animal.description);
    }

    @Test
    public void testMultipleAnimals() {
        Animal dog = new Animal();
        dog.name = "Dog";
        dog.description = "Loyal companion";

        Animal cat = new Animal();
        cat.name = "Cat";
        cat.description = "Independent pet";

        assertNotEquals(dog.name, cat.name);
        assertNotEquals(dog.description, cat.description);
    }
}
