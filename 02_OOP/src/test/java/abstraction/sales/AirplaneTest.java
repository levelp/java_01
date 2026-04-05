package abstraction.sales;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirplaneTest {

    @Test
    public void testAirplaneConstruction() {
        Airplane airplane = new Airplane();
        assertNotNull(airplane);
    }

    @Test
    public void testBusinessClassArrayExists() {
        Airplane airplane = new Airplane();
        assertNotNull(airplane.business);
        assertEquals(10, airplane.business.length);
    }

    @Test
    public void testEconomClassArrayExists() {
        Airplane airplane = new Airplane();
        assertNotNull(airplane.econom);
        assertEquals(10, airplane.econom.length);
    }

    @Test
    public void testBusinessClassInitialization() {
        Airplane airplane = new Airplane();
        for (int i = 0; i < airplane.business.length; i++) {
            assertNull(airplane.business[i]);
        }
    }

    @Test
    public void testEconomClassInitialization() {
        Airplane airplane = new Airplane();
        for (int i = 0; i < airplane.econom.length; i++) {
            assertNull(airplane.econom[i]);
        }
    }

    @Test
    public void testAddPlaceToBusinessClass() {
        Airplane airplane = new Airplane();
        Place place = new Place();
        place.num = 1;
        place.price = 5000.0;

        airplane.business[0] = place;

        assertNotNull(airplane.business[0]);
        assertEquals(1, airplane.business[0].num);
        assertEquals(5000.0, airplane.business[0].price, 0.01);
    }

    @Test
    public void testAddPlaceToEconomClass() {
        Airplane airplane = new Airplane();
        Place place = new Place();
        place.num = 1;
        place.price = 1000.0;

        airplane.econom[0] = place;

        assertNotNull(airplane.econom[0]);
        assertEquals(1, airplane.econom[0].num);
        assertEquals(1000.0, airplane.econom[0].price, 0.01);
    }

    @Test
    public void testFillBusinessClass() {
        Airplane airplane = new Airplane();
        for (int i = 0; i < airplane.business.length; i++) {
            Place place = new Place();
            place.num = i + 1;
            place.price = 5000.0 + i * 100;
            airplane.business[i] = place;
        }

        for (int i = 0; i < airplane.business.length; i++) {
            assertNotNull(airplane.business[i]);
            assertEquals(i + 1, airplane.business[i].num);
        }
    }

    @Test
    public void testFillEconomClass() {
        Airplane airplane = new Airplane();
        for (int i = 0; i < airplane.econom.length; i++) {
            Place place = new Place();
            place.num = i + 1;
            place.price = 1000.0 + i * 50;
            airplane.econom[i] = place;
        }

        for (int i = 0; i < airplane.econom.length; i++) {
            assertNotNull(airplane.econom[i]);
            assertEquals(i + 1, airplane.econom[i].num);
        }
    }

    @Test
    public void testMultipleAirplanes() {
        Airplane airplane1 = new Airplane();
        Airplane airplane2 = new Airplane();

        assertNotNull(airplane1);
        assertNotNull(airplane2);
        assertNotSame(airplane1, airplane2);
        assertNotSame(airplane1.business, airplane2.business);
        assertNotSame(airplane1.econom, airplane2.econom);
    }
}
