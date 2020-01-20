package org.wahlzeit.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MotorcyclePhotoTest {

    @Test
    public void testCreateMotorcyclePhoto(){
        Motorcycle motorcycle = MotorcycleManager.getInstance().createMotorcycle("Super Sports","BMW","S1000RR",180,1000,200,new Date(2019,1,1),0);
        MotorcyclePhoto photo = new MotorcyclePhoto(motorcycle);

        assertEquals(motorcycle,photo.getMotorcycle());
    }
}
