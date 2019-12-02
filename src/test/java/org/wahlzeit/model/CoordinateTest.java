package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoordinateTest {

    @Test
    public void testInterpretation() {
        CartesianCoordinate cc = new CartesianCoordinate(5.0,-3.0,2.0);
        SphericCoordinate sc = new SphericCoordinate(Math.PI,0,3.0);

        CartesianCoordinate ccCopy = cc.asSphericCoordinate().asCartesianCoordinate();
        SphericCoordinate scCopy = sc.asCartesianCoordinate().asSphericCoordinate();

        assertEquals(cc,ccCopy);
        assertEquals(sc,scCopy);
    }

    @Test
    public void testIsEqual() {
        CartesianCoordinate cc = new CartesianCoordinate(5.0,-3.0,2.0);
        SphericCoordinate sc = new SphericCoordinate(4.0,8.0,3.0);

        boolean equals1 = cc.isEqual(cc.asSphericCoordinate());
        boolean equals2 = sc.isEqual(sc.asCartesianCoordinate());

        assertTrue(equals1);
        assertTrue(equals2);
    }

    @Test
    public void testHashCode() {
        CartesianCoordinate cc = new CartesianCoordinate(5.0,-3.0,2.0);
        SphericCoordinate sc = new SphericCoordinate(4.0,8.0,3.0);

        int ccHash1 = cc.hashCode();
        int ccHash2 = cc.asSphericCoordinate().hashCode();
        int scHash1 = sc.hashCode();
        int scHash2 = sc.asCartesianCoordinate().hashCode();

        assertEquals(ccHash1,ccHash2);
        assertEquals(scHash1,scHash2);
    }

    @Test
    public void testDistance() {
        final double delta = 0.001;
        CartesianCoordinate cc1 = new CartesianCoordinate(5.0,-3.0,2.0);
        CartesianCoordinate cc2 = new CartesianCoordinate(6.0,1.0,-2.0);

        SphericCoordinate sc1 = cc1.asSphericCoordinate();
        SphericCoordinate sc2 = cc2.asSphericCoordinate();
        double cartesianDistRef = cc1.getCartesianDistance(cc2);
        double cartesianDistSpherical = sc1.getCartesianDistance(sc2);
        double cartesianDistMixed = cc1.getCartesianDistance(sc2);

        assertEquals(cartesianDistRef,cartesianDistSpherical,delta);
        assertEquals(cartesianDistRef,cartesianDistMixed,delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDistancePrecondition() {
        Coordinate c1 = new CartesianCoordinate(5.0,-3.0,2.0);

        c1.getCentralAngle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCentralAnglePrecondition() {
        Coordinate c1 = new CartesianCoordinate(5.0,-3.0,2.0);

        c1.getCentralAngle(null);
    }

}
