package org.wahlzeit.model;

public class MotorcyclePhoto extends Photo {

    private Motorcycle motorcycle;

    public MotorcyclePhoto() {
    }

    public MotorcyclePhoto(PhotoId myId) {
        super(myId);
    }

    public MotorcyclePhoto(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public MotorcyclePhoto(PhotoId myId, Motorcycle motorcycle) {
        super(myId);
        this.motorcycle = motorcycle;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }
}
