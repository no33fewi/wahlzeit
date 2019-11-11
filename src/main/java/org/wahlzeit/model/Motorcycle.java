package org.wahlzeit.model;

import java.util.Date;

public class Motorcycle {

    private String brand;
    private String model;
    private MotorcycleType type;

    private double weight;
    private double displacement;
    private double power;

    private Date registrationDate;
    private int kilometer;

    public Motorcycle(String brand, String model, MotorcycleType type, double weight, double displacement, double power, Date registrationDate, int kilometer) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.weight = weight;
        this.displacement = displacement;
        this.power = power;
        this.registrationDate = registrationDate;
        this.kilometer = kilometer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public MotorcycleType getType() { return type; }

    public void setType(MotorcycleType type) { this.type = type; }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }
}
