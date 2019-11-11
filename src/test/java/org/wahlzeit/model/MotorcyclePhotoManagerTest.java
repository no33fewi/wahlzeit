package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

import static org.junit.Assert.*;

public class MotorcyclePhotoManagerTest {

    @ClassRule
    public static RuleChain chain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider());

    @Before
    public void setUp() {
        MotorcyclePhotoFactory.resetInstance();
        MotorcyclePhotoFactory.initialize();
        MotorcyclePhotoManager.resetInstance();
        MotorcyclePhotoManager.initialize();
    }

    @Test
    public void testGetInstance(){
        MotorcyclePhotoManager manager = MotorcyclePhotoManager.getInstance();
        MotorcyclePhotoManager other = MotorcyclePhotoManager.getInstance();

        assertNotNull(manager);
        assertSame(manager, other);
    }

    @Test
    public void testPhotoAdd(){
        MotorcyclePhotoManager manager = MotorcyclePhotoManager.getInstance();
        MotorcyclePhoto photo = new MotorcyclePhoto();

        try {
            manager.addPhoto(photo);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        boolean hasPhoto = manager.hasPhoto(photo.getId());

        assertTrue(hasPhoto);
    }


}
