package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate implements Coordinate {

    private double phi, theta, radius;

    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = this.radius * Math.sin(this.theta) * Math.cos(this.phi);
        double y = this.radius * Math.sin(this.theta) * Math.sin(this.phi);
        double z = this.radius * Math.cos(this.theta);
        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public double getCartesianDistance(Coordinate other) {
        return asCartesianCoordinate().getCartesianDistance(other);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate other) {
        if(other==null)
            throw new NullPointerException();
        SphericCoordinate otherSpheric = other.asSphericCoordinate();
        return Math.acos(Math.sin(this.theta) * Math.sin(otherSpheric.getTheta()) +
                Math.cos(this.theta) * Math.cos(otherSpheric.getTheta()) * Math.cos(this.phi - otherSpheric.getPhi()));
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        return asCartesianCoordinate().isEqual(coordinate);
    }

    public String asString() {
        return "(phi: " + phi + ", theta: " + theta + ", radius: " + radius + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return isEqual(that);
    }

    @Override
    public int hashCode() {
        return asCartesianCoordinate().hashCode();
    }

    @Override
    public String toString() {
        return asString();
    }
}
