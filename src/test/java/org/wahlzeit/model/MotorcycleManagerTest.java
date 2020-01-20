package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;


public class MotorcycleManagerTest {

    @Test
    public void testGetInstance(){
        MotorcycleManager manager = MotorcycleManager.getInstance();
        MotorcycleManager other = MotorcycleManager.getInstance();

        assertNotNull(manager);
        assertSame(manager, other);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMotorcycleNullType(){
        MotorcycleManager manager = MotorcycleManager.getInstance();

        manager.createMotorcycle(null);
    }

    public void testCreateMotorcycle(){
        MotorcycleManager manager = MotorcycleManager.getInstance();

        Motorcycle motorcycle = manager.createMotorcycle("Chopper");
        MotorcycleType type = manager.getMotorcycleType("Chopper");

        assertNotNull(motorcycle);
        assertSame(type,motorcycle.getType());
    }

    public void testGetMotorcycleType(){
        MotorcycleManager manager = MotorcycleManager.getInstance();

        MotorcycleType a = manager.getMotorcycleType("Naked Bike");
        MotorcycleType b = manager.getMotorcycleType("Naked Bike");
        MotorcycleType c = manager.getMotorcycleType("Supermoto");

        assertSame(a,b);
        assertNotSame(a,c);
    }
}
