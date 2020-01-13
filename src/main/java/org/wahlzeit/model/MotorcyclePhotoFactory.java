package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.PatternInstance;

import java.util.logging.Logger;

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"ConcreteFactory"}
)
@PatternInstance(
        patternName = "Singleton",
        participants = {"Singleton"}
)
public class MotorcyclePhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(MotorcyclePhotoFactory.class.getName());

    public static void initialize() {
        setInstance(new MotorcyclePhotoFactory());
    }

    public static synchronized MotorcyclePhotoFactory getInstance() {
        return (MotorcyclePhotoFactory)PhotoFactory.getInstance();
    }

    @Override
    public MotorcyclePhoto createPhoto() {
        return new MotorcyclePhoto();
    }

    @Override
    public MotorcyclePhoto createPhoto(PhotoId id) {
        return new MotorcyclePhoto(id);
    }

    @Override
    public MotorcyclePhoto loadPhoto(PhotoId id) {
        return (MotorcyclePhoto)super.loadPhoto(id);
    }
}
