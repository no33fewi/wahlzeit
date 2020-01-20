package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MotorcycleTypeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullSubtype(){
        MotorcycleType type = new MotorcycleType("Dirt Bike");

        type.addSubType(null);
    }

    @Test
    public void testEquals(){
        MotorcycleType a = new MotorcycleType("Dirt Bike");
        MotorcycleType b = new MotorcycleType("Dirt Bike");

        boolean equals = a.equals(b);

        assertTrue(equals);
    }

    @Test
    public void testCreateInstance(){
        MotorcycleType type = new MotorcycleType("Dirt Bike");

        Motorcycle motorcycle = type.createInstance();

        assertNotNull(motorcycle);
        assertSame(type,motorcycle.getType());
    }

    @Test
    public void testHasInstance(){
        MotorcycleType dirtType = new MotorcycleType("Dirt Bike");
        MotorcycleType chopperType = new MotorcycleType("Chopper");

        Motorcycle dirtBike = dirtType.createInstance();
        Motorcycle chopper = chopperType.createInstance();

        assertTrue(dirtType.hasInstance(dirtBike));
        assertTrue(chopperType.hasInstance(chopper));
        assertFalse(dirtType.hasInstance(chopper));
        assertFalse(chopperType.hasInstance(dirtBike));
    }

    @Test
    public void testIsSupertype(){
        MotorcycleType type = new MotorcycleType("Dirt Bike");
        MotorcycleType subType = new MotorcycleType("Racing Dirt Bike");
        MotorcycleType otherType = new MotorcycleType("Chopper");

        type.addSubType(subType);

        assertTrue(subType.isSubtype());
        assertFalse(type.isSubtype());
        assertFalse(otherType.isSubtype());
    }

    @Test
    public void testIsSubtypeOf(){
        MotorcycleType superType = new MotorcycleType("Motorcycle");
        MotorcycleType type = new MotorcycleType("Dirt Bike");
        MotorcycleType subType = new MotorcycleType("Racing Dirt Bike");
        MotorcycleType otherType = new MotorcycleType("Chopper");

        superType.addSubType(type);
        superType.addSubType(otherType);
        type.addSubType(subType);

        assertTrue(subType.isSubtypeOf(superType));
        assertTrue(subType.isSubtypeOf(type));
        assertFalse(type.isSubtypeOf(subType));
        assertFalse(otherType.isSubtypeOf(type));
    }

}
