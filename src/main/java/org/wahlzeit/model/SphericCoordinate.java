package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

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
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }
}
