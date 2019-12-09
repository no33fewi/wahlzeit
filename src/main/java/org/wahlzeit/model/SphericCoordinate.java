package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

    private double phi, theta, radius;

    public SphericCoordinate(double phi, double theta, double radius) throws IllegalArgumentException, IllegalStateException {
        if(!Double.isFinite(phi))
            throw new IllegalArgumentException("Phi must be a finite value. The value " + phi + " is not valid");
        if(!Double.isFinite(theta))
            throw new IllegalArgumentException("Theta must be a finite value. The value " + theta + " is not valid");
        if(!Double.isFinite(radius))
            throw new IllegalArgumentException("Radius must be a finite value. The value " + radius + " is not valid");

        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        assertClassInvariant();
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        if(!Double.isFinite(phi))
            throw new IllegalArgumentException("Phi must be a finite value. The value " + phi + " is not valid");
        this.phi = phi;
        assertClassInvariant();
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        if(!Double.isFinite(theta))
            throw new IllegalArgumentException("Theta must be a finite value. The value " + theta + " is not valid");
        this.theta = theta;
        assertClassInvariant();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(!Double.isFinite(radius))
            throw new IllegalArgumentException("Radius must be a finite value. The value " + radius + " is not valid");
        this.radius = radius;
        assertClassInvariant();
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

    @Override
    protected void assertClassInvariant() {
        if(!Double.isFinite(this.phi)||!Double.isFinite(this.theta)||!Double.isFinite(this.radius)||this.radius < 0)
            throw new IllegalStateException("Class invariant violation");
    }
}
