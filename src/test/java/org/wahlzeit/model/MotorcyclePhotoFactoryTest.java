package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MotorcyclePhotoFactoryTest {

    @Before
    public void setUp() {
        MotorcyclePhotoFactory.resetInstance();
        MotorcyclePhotoFactory.initialize();
    }

    @Test
    public void testGetInstance(){
        MotorcyclePhotoFactory factory = MotorcyclePhotoFactory.getInstance();
        MotorcyclePhotoFactory other = MotorcyclePhotoFactory.getInstance();

        assertNotNull(factory);
        assertSame(factory, other);
    }

    @Test
    public void testCreateMotorcyclePhoto() {
        MotorcyclePhotoFactory factory = MotorcyclePhotoFactory.getInstance();

        MotorcyclePhoto photo = factory.createPhoto();

        assertNotNull(photo);
    }
}
