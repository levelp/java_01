package abstraction.sales;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for abstraction.sales.Airplane
 */
public class SalesAirplaneTest {

    private Airplane airplane;

    @Before
    public void setUp() {
        airplane = new Airplane();
    }

    @Test
    public void testConstructor() {
        Airplane plane = new Airplane();
        assertNotNull("Constructor should create non-null instance", plane);
    }

    @Test
    public void testBusinessArrayNotNull() {
        assertNotNull("Business array should not be null", airplane.business);
    }

    @Test
    public void testEconomArrayNotNull() {
        assertNotNull("Econom array should not be null", airplane.econom);
    }

    @Test
    public void testBusinessArrayLength() {
        assertEquals("Business array should have 10 elements", 10, airplane.business.length);
    }

    @Test
    public void testEconomArrayLength() {
        assertEquals("Econom array should have 10 elements", 10, airplane.econom.length);
    }

    @Test
    public void testBusinessArrayInitiallyNull() {
        for (int i = 0; i < airplane.business.length; i++) {
            assertNull("Business place at index " + i + " should initially be null",
                      airplane.business[i]);
        }
    }

    @Test
    public void testEconomArrayInitiallyNull() {
        for (int i = 0; i < airplane.econom.length; i++) {
            assertNull("Econom place at index " + i + " should initially be null",
                      airplane.econom[i]);
        }
    }

    @Test
    public void testAddBusinessPlace() {
        Place place = new Place();
        place.num = 1;
        place.price = 500.0;

        airplane.business[0] = place;

        assertNotNull("Business place should be set", airplane.business[0]);
        assertEquals("Business place number should be 1", 1, airplane.business[0].num);
        assertEquals("Business place price should be 500.0", 500.0,
                    airplane.business[0].price, 1e-10);
    }

    @Test
    public void testAddEconomPlace() {
        Place place = new Place();
        place.num = 15;
        place.price = 150.0;

        airplane.econom[0] = place;

        assertNotNull("Econom place should be set", airplane.econom[0]);
        assertEquals("Econom place number should be 15", 15, airplane.econom[0].num);
        assertEquals("Econom place price should be 150.0", 150.0,
                    airplane.econom[0].price, 1e-10);
    }

    @Test
    public void testFillAllBusinessPlaces() {
        for (int i = 0; i < airplane.business.length; i++) {
            Place place = new Place();
            place.num = i + 1;
            place.price = 500.0 + i * 10;
            airplane.business[i] = place;
        }

        for (int i = 0; i < airplane.business.length; i++) {
            assertNotNull("Business place at index " + i + " should not be null",
                         airplane.business[i]);
            assertEquals("Business place number should match",
                        i + 1, airplane.business[i].num);
        }
    }

    @Test
    public void testFillAllEconomPlaces() {
        for (int i = 0; i < airplane.econom.length; i++) {
            Place place = new Place();
            place.num = i + 11;
            place.price = 150.0 + i * 5;
            airplane.econom[i] = place;
        }

        for (int i = 0; i < airplane.econom.length; i++) {
            assertNotNull("Econom place at index " + i + " should not be null",
                         airplane.econom[i]);
            assertEquals("Econom place number should match",
                        i + 11, airplane.econom[i].num);
        }
    }

    @Test
    public void testMultipleAirplaneInstances() {
        Airplane airplane1 = new Airplane();
        Airplane airplane2 = new Airplane();

        Place place1 = new Place();
        place1.num = 1;
        airplane1.business[0] = place1;

        Place place2 = new Place();
        place2.num = 2;
        airplane2.business[0] = place2;

        assertEquals("Airplane1 business place should be 1",
                    1, airplane1.business[0].num);
        assertEquals("Airplane2 business place should be 2",
                    2, airplane2.business[0].num);
        assertNull("Airplane1 econom should still be null",
                  airplane1.econom[0]);
        assertNull("Airplane2 econom should still be null",
                  airplane2.econom[0]);
    }

    @Test
    public void testMixedPlaceAssignment() {
        Place business1 = new Place();
        business1.num = 5;
        business1.price = 600.0;

        Place econom1 = new Place();
        econom1.num = 15;
        econom1.price = 200.0;

        airplane.business[5] = business1;
        airplane.econom[5] = econom1;

        assertEquals("Business place at index 5 should have num 5",
                    5, airplane.business[5].num);
        assertEquals("Econom place at index 5 should have num 15",
                    15, airplane.econom[5].num);
        assertEquals("Business price should be 600.0",
                    600.0, airplane.business[5].price, 1e-10);
        assertEquals("Econom price should be 200.0",
                    200.0, airplane.econom[5].price, 1e-10);
    }

    @Test
    public void testTotalCapacity() {
        int totalCapacity = airplane.business.length + airplane.econom.length;
        assertEquals("Total airplane capacity should be 20", 20, totalCapacity);
    }
}
