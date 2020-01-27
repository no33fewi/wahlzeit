package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

/*
Creation Sequence:
UploadPhotoFromHandler.doHandlePost(...) / ModelMain.createUser(...) ->
MotorcyclePhotoManager.createPhoto(...) -> PhotoUtil.createPhoto(...) ->
MotorcyclePhotoFactory.createPhoto(...) -> MotorcyclePhoto.ctor(...)
Object Creation Solution: (separate-object, by-subclassing, in-code, in-code, by-fixed-signature / default, default)
 */
@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"ConcreteProduct"}
)
public class MotorcyclePhoto extends Photo {

    private Motorcycle motorcycle;

    public MotorcyclePhoto() {
    }

    public MotorcyclePhoto(PhotoId myId) {
        super(myId);
    }

    public MotorcyclePhoto(Motorcycle motorcycle) {
        if (motorcycle == null)
            throw new IllegalArgumentException("Motorcycle should not be null");
        this.motorcycle = motorcycle;
    }

    public MotorcyclePhoto(PhotoId myId, Motorcycle motorcycle) {
        super(myId);
        if (motorcycle == null)
            throw new IllegalArgumentException("Motorcycle should not be null");
        this.motorcycle = motorcycle;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null)
            throw new IllegalArgumentException("Motorcycle should not be null");
        this.motorcycle = motorcycle;
    }
}
