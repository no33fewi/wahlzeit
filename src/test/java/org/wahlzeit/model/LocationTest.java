package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class LocationTest {

    @Test
    public void testLocation(){
        final String name = "somewhere";

        CartesianCoordinate coordinate = new CartesianCoordinate(1.0,2.0,3.0);
        Location location = new Location(name, coordinate);

        Assert.assertEquals(name,location.getName());
        Assert.assertEquals(coordinate,location.coordinate);
    }

    @Test
    public void testSetCoordinate(){
        final String name = "somewhere";
        CartesianCoordinate coordinate0 = new CartesianCoordinate(1.0,2.0,3.0);
        CartesianCoordinate coordinate1 = new CartesianCoordinate(5.0,5.0,5.0);
        Location location = new Location(name, coordinate0);

        location.setCoordinate(coordinate1);

        Assert.assertEquals(coordinate1,location.coordinate);
    }

}
