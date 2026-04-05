package abstraction.sales;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.reflect.Field;

/**
 * Comprehensive test class for Place
 */
public class PlaceTest {

    private Place place;

    @Before
    public void setUp() {
        place = new Place();
    }

    @Test
    public void testConstructor() {
        Place p = new Place();
        assertNotNull("Constructor should create non-null instance", p);
    }

    @Test
    public void testDefaultNumValue() {
        // Default value for int is 0
        assertEquals("Default num should be 0", 0, place.num);
    }

    @Test
    public void testDefaultPriceValue() {
        // Default value for double is 0.0
        assertEquals("Default price should be 0.0", 0.0, place.price, 1e-10);
    }

    @Test
    public void testSetNum() {
        place.num = 42;
        assertEquals("Num should be set to 42", 42, place.num);
    }

    @Test
    public void testSetPrice() {
        place.price = 150.50;
        assertEquals("Price should be set to 150.50", 150.50, place.price, 1e-10);
    }

    @Test
    public void testSetNumNegative() {
        place.num = -5;
        assertEquals("Num should accept negative values", -5, place.num);
    }

    @Test
    public void testSetPriceNegative() {
        place.price = -10.5;
        assertEquals("Price should accept negative values", -10.5, place.price, 1e-10);
    }

    @Test
    public void testSetPriceZero() {
        place.price = 0.0;
        assertEquals("Price should accept zero", 0.0, place.price, 1e-10);
    }

    @Test
    public void testSetNumZero() {
        place.num = 0;
        assertEquals("Num should accept zero", 0, place.num);
    }

    @Test
    public void testSetNumLargeValue() {
        place.num = Integer.MAX_VALUE;
        assertEquals("Num should accept MAX_VALUE", Integer.MAX_VALUE, place.num);
    }

    @Test
    public void testSetPriceLargeValue() {
        place.price = Double.MAX_VALUE;
        assertEquals("Price should accept MAX_VALUE", Double.MAX_VALUE, place.price, 1e-10);
    }

    @Test
    public void testMultipleInstances() {
        Place place1 = new Place();
        Place place2 = new Place();

        place1.num = 1;
        place1.price = 100.0;

        place2.num = 2;
        place2.price = 200.0;

        assertEquals("place1.num should be 1", 1, place1.num);
        assertEquals("place2.num should be 2", 2, place2.num);
        assertEquals("place1.price should be 100.0", 100.0, place1.price, 1e-10);
        assertEquals("place2.price should be 200.0", 200.0, place2.price, 1e-10);
    }

    @Test
    public void testFieldsArePackagePrivate() throws Exception {
        Field numField = Place.class.getDeclaredField("num");
        Field priceField = Place.class.getDeclaredField("price");

        // Package-private fields have no modifiers (0)
        int numModifiers = numField.getModifiers();
        int priceModifiers = priceField.getModifiers();

        // Neither should be private, protected, or public
        assertFalse("num should not be private",
                    java.lang.reflect.Modifier.isPrivate(numModifiers));
        assertFalse("num should not be protected",
                    java.lang.reflect.Modifier.isProtected(numModifiers));
        assertFalse("num should not be public",
                    java.lang.reflect.Modifier.isPublic(numModifiers));

        assertFalse("price should not be private",
                    java.lang.reflect.Modifier.isPrivate(priceModifiers));
        assertFalse("price should not be protected",
                    java.lang.reflect.Modifier.isProtected(priceModifiers));
        assertFalse("price should not be public",
                    java.lang.reflect.Modifier.isPublic(priceModifiers));
    }

    @Test
    public void testTypicalBusinessClassPlace() {
        place.num = 5;
        place.price = 500.0;

        assertEquals("Business class seat number", 5, place.num);
        assertEquals("Business class price", 500.0, place.price, 1e-10);
    }

    @Test
    public void testTypicalEconomyClassPlace() {
        place.num = 15;
        place.price = 150.0;

        assertEquals("Economy class seat number", 15, place.num);
        assertEquals("Economy class price", 150.0, place.price, 1e-10);
    }
}
