import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Test class for MyClass
 */
public class MyClassTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;
    private final String testFilePath = "08_ConsoleDemo/test_data.txt";

    @Before
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void tearDown() {
        System.setIn(systemIn);
        System.setOut(systemOut);
        // Clean up test file if exists
        try {
            Files.deleteIfExists(Paths.get(testFilePath));
        } catch (IOException e) {
            // Ignore
        }
    }

    @Test
    public void testMainMethodExists() throws Exception {
        // Test that main method can be called
        assertNotNull(MyClass.class.getMethod("main", String[].class));
    }

    @Test
    public void testSystemPropertyWorking() {
        String workingDir = System.getProperty("user.dir");
        assertNotNull(workingDir);
        assertFalse(workingDir.isEmpty());
    }

    @Test(expected = FileNotFoundException.class)
    public void testMainWithMissingFile() throws Exception {
        // This tests that FileNotFoundException is properly declared
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Since the data file doesn't exist in test context, this should throw FileNotFoundException
        MyClass.main(new String[]{});
    }

    @Test
    public void testAnimalListCreation() {
        // Test that Animal objects can be created and used
        java.util.List<Animal> list = new java.util.ArrayList<>();

        Animal animal1 = new Animal();
        animal1.name = "Cat";
        animal1.description = "Meows";
        list.add(animal1);

        Animal animal2 = new Animal();
        animal2.name = "Dog";
        animal2.description = "Barks";
        list.add(animal2);

        assertEquals(2, list.size());
        assertEquals("Cat", list.get(0).name);
        assertEquals("Dog", list.get(1).name);
    }

    @Test
    public void testRandomAnimalSelection() {
        java.util.Random gen = new java.util.Random(42); // Fixed seed for reproducibility
        java.util.List<Animal> list = new java.util.ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Animal animal = new Animal();
            animal.name = "Animal" + i;
            animal.description = "Description" + i;
            list.add(animal);
        }

        int randomIndex = gen.nextInt(list.size());
        assertTrue(randomIndex >= 0 && randomIndex < list.size());
    }

    @Test
    public void testAnimalListRemoval() {
        java.util.List<Animal> list = new java.util.ArrayList<>();

        Animal animal = new Animal();
        animal.name = "Bear";
        animal.description = "Hibernates";
        list.add(animal);

        assertEquals(1, list.size());
        list.remove(animal);
        assertEquals(0, list.size());
    }

    @Test
    public void testAnimalChoice() {
        java.util.List<Animal> choice = new java.util.ArrayList<>();
        Animal rightAnimal = new Animal();
        rightAnimal.name = "Lion";
        rightAnimal.description = "Roars";
        choice.add(rightAnimal);

        Animal wrongAnimal = new Animal();
        wrongAnimal.name = "Tiger";
        wrongAnimal.description = "Growls";
        choice.add(wrongAnimal);

        assertEquals(2, choice.size());
        assertTrue(choice.contains(rightAnimal));
        assertTrue(choice.contains(wrongAnimal));
    }

    @Test
    public void testAnimalNameComparison() {
        Animal animal1 = new Animal();
        animal1.name = "Elephant";

        Animal animal2 = new Animal();
        animal2.name = "Elephant";

        Animal animal3 = new Animal();
        animal3.name = "Giraffe";

        assertTrue(animal1.name.equals(animal2.name));
        assertFalse(animal1.name.equals(animal3.name));
    }
}
