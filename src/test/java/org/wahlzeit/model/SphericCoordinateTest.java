package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class SphericCoordinateTest {

    @Test
    public void testShared() {
        SphericCoordinate coordinate0 = SphericCoordinate.getSphericCoordinate(1.0, 0.0, 1.0);
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(1.0, 0.0, 1.0);
        SphericCoordinate coordinate2 = SphericCoordinate.getSphericCoordinate(2.0, 0.0, 1.0);

        assertSame(coordinate0,coordinate1);
        assertNotSame(coordinate0,coordinate2);
    }

    @Test
    public void testImmutable() {
        SphericCoordinate coordinate0 = SphericCoordinate.getSphericCoordinate(1.0, 0.0, 1.0);

        SphericCoordinate coordinate1 = coordinate0.withRadius(4.0);

        assertNotEquals(coordinate0,coordinate1);
        assertNotSame(coordinate0,coordinate1);
    }

    @Test
    public void testGetters() {
        final double delta = 0.001;
        double phi = 5.0, theta = 10.0, radius = 15.0;

        SphericCoordinate coordinate = SphericCoordinate.getSphericCoordinate(phi, theta, radius);

        assertEquals(phi,coordinate.getPhi(),delta);
        assertEquals(theta,coordinate.getTheta(),delta);
        assertEquals(radius,coordinate.getRadius(),delta);
    }

    @Test
    public void testCentralAngle() {
        final double delta = 0.001;
        SphericCoordinate coordinate0 = CartesianCoordinate.getCartesianCoordinate(1.0, 0.0, 0.0).asSphericCoordinate();
        SphericCoordinate coordinate1 = CartesianCoordinate.getCartesianCoordinate(0.0, 0.0, 1.0).asSphericCoordinate();

        double centralAngle = coordinate0.getCentralAngle(coordinate1);

        assertEquals(Math.PI / 2,centralAngle,delta);
    }

    @Test
    public void testGetDistance() {
        final double delta = 0.001;
        SphericCoordinate coordinate0 = CartesianCoordinate.getCartesianCoordinate(0.0,0.0,0.0).asSphericCoordinate();
        SphericCoordinate coordinate1 = CartesianCoordinate.getCartesianCoordinate(1.0,1.0,1.0).asSphericCoordinate();

        double distC0C0 = coordinate0.getCartesianDistance(coordinate0);
        double distC1C1 = coordinate1.getCartesianDistance(coordinate1);
        double distC0C1 = coordinate0.getCartesianDistance(coordinate1);
        double distC1C0 = coordinate1.getCartesianDistance(coordinate0);

        assertEquals(0,distC0C0,delta);
        assertEquals(0,distC1C1,delta);
        assertEquals(Math.sqrt(3),distC0C1,delta);
        assertEquals(Math.sqrt(3),distC1C0,delta);
    }

    @Test
    public void testIsEqual(){
        SphericCoordinate coordinate0 = SphericCoordinate.getSphericCoordinate(5.0,8.0,4.0);
        SphericCoordinate coordinate1 = SphericCoordinate.getSphericCoordinate(2.0,7.0,4.0);
        SphericCoordinate coordinate2 = SphericCoordinate.getSphericCoordinate(2.0,7.0,4.0);

        assertFalse(coordinate0.isEqual(coordinate1));
        assertFalse(coordinate1.isEqual(coordinate0));
        assertTrue(coordinate1.isEqual(coordinate2));
        assertTrue(coordinate2.isEqual(coordinate1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClassInvariant() {
        double phi = Double.NaN, theta = 10.0, radius = 15.0;

        SphericCoordinate coordinate = SphericCoordinate.getSphericCoordinate(phi, theta, radius);
    }
}
