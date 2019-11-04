package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;


public class CoordinateTest {

    @Test
    public void testGetters() {
        final double delta = 0.001;
        double x = 5.0, y = 10.0, z = 15.0;

        Coordinate coordinate = new Coordinate(x,y,z);

        assertEquals(x,coordinate.getX(),delta);
        assertEquals(y,coordinate.getY(),delta);
        assertEquals(z,coordinate.getZ(),delta);
    }

    @Test
    public void testGetDistance() {
        final double delta = 0.001;
        Coordinate coordinate0 = new Coordinate(0.0,0.0,0.0);
        Coordinate coordinate1 = new Coordinate(1.0,1.0,1.0);

        double distC0C0 = coordinate0.getDistance(coordinate0);
        double distC1C1 = coordinate1.getDistance(coordinate1);
        double distC0C1 = coordinate0.getDistance(coordinate1);
        double distC1C0 = coordinate1.getDistance(coordinate0);

        assertEquals(0,distC0C0,delta);
        assertEquals(0,distC1C1,delta);
        assertEquals(Math.sqrt(3),distC0C1,delta);
        assertEquals(Math.sqrt(3),distC1C0,delta);
    }

    @Test
    public void testIsEqual(){
        final double delta = 0.001;

        Coordinate coordinate0 = new Coordinate(5.0,8.0,4.0);
        Coordinate coordinate1 = new Coordinate(2.0,7.0,4.0);
        Coordinate coordinate2 = new Coordinate(2.0,7.0,4.0);

        assertFalse(coordinate0.isEqual(coordinate1));
        assertFalse(coordinate1.isEqual(coordinate0));
        assertTrue(coordinate1.isEqual(coordinate2));
        assertTrue(coordinate2.isEqual(coordinate1));
    }
}
