package abstraction.flysupport;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Comprehensive test class for abstraction.flysupport.Airplane
 */
public class FlysupportAirplaneTest {

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
    public void testDefaultMaxSpeed() {
        assertEquals("Default maxSpeed should be 0.0", 0.0, airplane.maxSpeed, 1e-10);
    }

    @Test
    public void testDefaultWeight() {
        assertEquals("Default weight should be 0.0", 0.0, airplane.weight, 1e-10);
    }

    @Test
    public void testSetMaxSpeed() {
        airplane.maxSpeed = 900.0;
        assertEquals("MaxSpeed should be 900.0 km/h", 900.0, airplane.maxSpeed, 1e-10);
    }

    @Test
    public void testSetWeight() {
        airplane.weight = 50000.0;
        assertEquals("Weight should be 50000.0 kg", 50000.0, airplane.weight, 1e-10);
    }

    @Test
    public void testSetMaxSpeedZero() {
        airplane.maxSpeed = 0.0;
        assertEquals("MaxSpeed should accept zero", 0.0, airplane.maxSpeed, 1e-10);
    }

    @Test
    public void testSetWeightZero() {
        airplane.weight = 0.0;
        assertEquals("Weight should accept zero", 0.0, airplane.weight, 1e-10);
    }

    @Test
    public void testSetMaxSpeedNegative() {
        airplane.maxSpeed = -100.0;
        assertEquals("MaxSpeed should accept negative values", -100.0, airplane.maxSpeed, 1e-10);
    }

    @Test
    public void testSetWeightNegative() {
        airplane.weight = -1000.0;
        assertEquals("Weight should accept negative values", -1000.0, airplane.weight, 1e-10);
    }

    @Test
    public void testSetMaxSpeedLarge() {
        airplane.maxSpeed = Double.MAX_VALUE;
        assertEquals("MaxSpeed should accept MAX_VALUE", Double.MAX_VALUE, airplane.maxSpeed, 1e-10);
    }

    @Test
    public void testSetWeightLarge() {
        airplane.weight = Double.MAX_VALUE;
        assertEquals("Weight should accept MAX_VALUE", Double.MAX_VALUE, airplane.weight, 1e-10);
    }

    @Test
    public void testMultipleInstances() {
        Airplane plane1 = new Airplane();
        Airplane plane2 = new Airplane();

        plane1.maxSpeed = 800.0;
        plane1.weight = 40000.0;

        plane2.maxSpeed = 1000.0;
        plane2.weight = 60000.0;

        assertEquals("plane1 maxSpeed should be 800", 800.0, plane1.maxSpeed, 1e-10);
        assertEquals("plane2 maxSpeed should be 1000", 1000.0, plane2.maxSpeed, 1e-10);
        assertEquals("plane1 weight should be 40000", 40000.0, plane1.weight, 1e-10);
        assertEquals("plane2 weight should be 60000", 60000.0, plane2.weight, 1e-10);
    }

    @Test
    public void testFieldsArePackagePrivate() throws Exception {
        Field maxSpeedField = Airplane.class.getDeclaredField("maxSpeed");
        Field weightField = Airplane.class.getDeclaredField("weight");

        int maxSpeedModifiers = maxSpeedField.getModifiers();
        int weightModifiers = weightField.getModifiers();

        // Package-private fields have no modifiers (0)
        assertFalse("maxSpeed should not be private",
                    Modifier.isPrivate(maxSpeedModifiers));
        assertFalse("maxSpeed should not be protected",
                    Modifier.isProtected(maxSpeedModifiers));
        assertFalse("maxSpeed should not be public",
                    Modifier.isPublic(maxSpeedModifiers));

        assertFalse("weight should not be private",
                    Modifier.isPrivate(weightModifiers));
        assertFalse("weight should not be protected",
                    Modifier.isProtected(weightModifiers));
        assertFalse("weight should not be public",
                    Modifier.isPublic(weightModifiers));
    }

    @Test
    public void testTypicalCommercialAirplane() {
        airplane.maxSpeed = 920.0;  // Typical cruising speed in km/h
        airplane.weight = 79015.0;  // Typical empty weight of Boeing 737

        assertEquals("Commercial airplane max speed", 920.0, airplane.maxSpeed, 1e-10);
        assertEquals("Commercial airplane weight", 79015.0, airplane.weight, 1e-10);
    }

    @Test
    public void testTypicalFighterJet() {
        airplane.maxSpeed = 2450.0;  // Typical fighter jet speed in km/h
        airplane.weight = 9979.0;    // Typical F-16 empty weight

        assertEquals("Fighter jet max speed", 2450.0, airplane.maxSpeed, 1e-10);
        assertEquals("Fighter jet weight", 9979.0, airplane.weight, 1e-10);
    }

    @Test
    public void testClassExists() {
        assertTrue("Airplane class should exist in abstraction.flysupport package",
                   Airplane.class.getName().equals("abstraction.flysupport.Airplane"));
    }

    @Test
    public void testSetMaxSpeedDecimal() {
        airplane.maxSpeed = 567.89;
        assertEquals("MaxSpeed should accept decimal values", 567.89, airplane.maxSpeed, 1e-10);
    }

    @Test
    public void testSetWeightDecimal() {
        airplane.weight = 12345.67;
        assertEquals("Weight should accept decimal values", 12345.67, airplane.weight, 1e-10);
    }

    @Test
    public void testReassignValues() {
        airplane.maxSpeed = 100.0;
        airplane.maxSpeed = 200.0;
        airplane.maxSpeed = 300.0;

        airplane.weight = 1000.0;
        airplane.weight = 2000.0;
        airplane.weight = 3000.0;

        assertEquals("MaxSpeed should be reassignable", 300.0, airplane.maxSpeed, 1e-10);
        assertEquals("Weight should be reassignable", 3000.0, airplane.weight, 1e-10);
    }
}
