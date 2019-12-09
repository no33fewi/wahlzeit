package org.wahlzeit.model;

public class MotorcyclePhoto extends Photo {

    private Motorcycle motorcycle;

    public MotorcyclePhoto() {
    }

    public MotorcyclePhoto(PhotoId myId) {
        super(myId);
    }

    public MotorcyclePhoto(Motorcycle motorcycle) {
        if(motorcycle == null)
            throw new IllegalArgumentException("Motorcycle should not be null");
        this.motorcycle = motorcycle;
    }

    public MotorcyclePhoto(PhotoId myId, Motorcycle motorcycle) {
        super(myId);
        if(motorcycle == null)
            throw new IllegalArgumentException("Motorcycle should not be null");
        this.motorcycle = motorcycle;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        if(motorcycle == null)
            throw new IllegalArgumentException("Motorcycle should not be null");
        this.motorcycle = motorcycle;
    }
}
