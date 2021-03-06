package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.util.Date;

/*
Creation Sequence: MotorcycleManager.createMotorcycle(...) -> MotorcycleType.createInstance(...) -> Motorcycle.ctor(...)
Object Creation Solution: (separate-object, on-the-spot, n/a, in-code, by-fixed-signature / default, default)
 */
public class Motorcycle extends DataObject {

    protected MotorcycleType type;

    private String brand;
    private String model;

    private double weight;
    private double displacement;
    private double power;

    private Date registrationDate;
    private int kilometer;

    public Motorcycle(MotorcycleType type){
        this.type = type;
    }

    public Motorcycle(MotorcycleType type, String brand, String model, double weight, double displacement, double power, Date registrationDate, int kilometer) {
        if(brand == null || brand.isEmpty())
            throw new IllegalArgumentException("Brand should not be null or empty");
        if(model == null || model.isEmpty())
            throw new IllegalArgumentException("Model should not be null or empty");
        if(!Double.isFinite(weight) || weight < 0)
            throw new IllegalArgumentException("Weight must be a finite number >= 0");
        if(!Double.isFinite(displacement) || displacement < 0)
            throw new IllegalArgumentException("Displacement must be a finite number >= 0");
        if(!Double.isFinite(power) || power < 0)
            throw new IllegalArgumentException("Power must be a finite number >= 0");
        if(registrationDate == null)
            throw new IllegalArgumentException("RegistrationDate should not be null");
        if(!Double.isFinite(kilometer) || kilometer < 0)
            throw new IllegalArgumentException("Kilometer must be a finite number and >= 0");

        this.type = type;
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.displacement = displacement;
        this.power = power;
        this.registrationDate = registrationDate;
        this.kilometer = kilometer;
    }

    public MotorcycleType getType() { return type; }

    public void setType(MotorcycleType type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand == null || brand.isEmpty())
            throw new IllegalArgumentException("Brand should not be null or empty");
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model == null || model.isEmpty())
            throw new IllegalArgumentException("Model should not be null or empty");
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(!Double.isFinite(weight) || weight < 0)
            throw new IllegalArgumentException("Weight must be a finite number >= 0");
        this.weight = weight;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        if(!Double.isFinite(displacement) || displacement < 0)
            throw new IllegalArgumentException("Displacement must be a finite number >= 0");
        this.displacement = displacement;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        if(!Double.isFinite(power) || power < 0)
            throw new IllegalArgumentException("Power must be a finite number >= 0");
        this.power = power;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        if(registrationDate == null)
            throw new IllegalArgumentException("RegistrationDate should not be null");
        this.registrationDate = registrationDate;
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer)
    {
        if(!Double.isFinite(kilometer) || kilometer < 0)
            throw new IllegalArgumentException("Kilometer must be a finite number and >= 0");
        this.kilometer = kilometer;
    }
}
